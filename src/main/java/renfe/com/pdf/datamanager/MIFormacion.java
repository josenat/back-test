package renfe.com.pdf.datamanager;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.ActasPersonaDto;
import renfe.com.model.dto.Tbasg115CalificacDto;
import renfe.com.model.dto.Tbasg120CentformaDto;
import renfe.com.model.dto.Tbasg122InstruDto;
import renfe.com.pdf.beans.FormacionDossierPersonalBean;
import renfe.com.service.Tbasg115CalificacService;
import renfe.com.service.Tbasg120CentformaService;
import renfe.com.service.Tbasg122InstruService;
import renfe.com.util.ImprimirCts;
import renfe.com.util.Util;

@Service
@Configurable
public class MIFormacion {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MIFormacion.class);

	private boolean Accion = false;
	private ActasPersonaDto objFormacion = null;

	private String sPre = "    ";

	@Autowired
	private Tbasg115CalificacService tbasg115CalificacService;
	@Autowired
	private Tbasg120CentformaService tbasg120CentformaService;
	@Autowired
	private Tbasg122InstruService tbasg122InstruService;

	public MIFormacion() {
	}

	public FormacionDossierPersonalBean MIF_Init() {
		ImprimirCts objCte = new ImprimirCts();
		FormacionDossierPersonalBean dto = new FormacionDossierPersonalBean();
		if (this.objFormacion != null)
			Accion = true;

		if (this.Accion) {
			int iB = 0;
			String Texto = "";
			dto.setLinea_000(objCte.FORMACION_LT_LI_000);

			dto.setLinea_001(this.sPre);
			// Curso - Codigo + descripcion
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_001.length();
			Texto = objCte.FORMACION_LT_LI_001 + (new Util().getPuntos(iB));

			if (this.objFormacion.getCdgoCurso() != null) {
				Texto = Texto + (String) this.objFormacion.getCdgoCurso() + " - ";
			}

			if (this.objFormacion.getDesgDesccurso() != null) {
				Texto = Texto + (String) this.objFormacion.getDesgDesccurso();
			}
			dto.addLinea_001(Texto);

			dto.setLinea_002(this.sPre); // Expediente/Fecha
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_002.length();
			Texto = objCte.FORMACION_LT_LI_002 + (new Util().getPuntos(iB));

			if (this.objFormacion.getCodigo() != null) {
				Texto = Texto + this.objFormacion.getCodigo().toString() + " / ";
			} else {
				Texto = Texto + objCte.FORMACION_LT_LI_A01 + " / ";
			}

			if (this.objFormacion.getFchaCurso() != null) {
				Texto = Texto + TextFormat.format((Date) this.objFormacion.getFchaCurso());
			} else {
				Texto = Texto + objCte.FORMACION_LT_LI_A02;
			}
			dto.addLinea_002(Texto);

			dto.setLinea_003(this.sPre); // Tipo/Calificación
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_003.length();
			Texto = objCte.FORMACION_LT_LI_003 + (new Util().getPuntos(iB));

			if (this.objFormacion.getDesgTipoCurso() != null) {
				Texto = Texto + this.objFormacion.getDesgTipoCurso().trim() + " / ";
			} else {
				Texto = Texto + objCte.FORMACION_LT_LI_A06 + " / ";
			}
			if (this.objFormacion.getCdgoCalifi() != null) {
				Tbasg115CalificacDto tb115 = this.tbasg115CalificacService
						.findByCdgoCalifi(this.objFormacion.getCdgoCalifi());
				String nombreCalifica = tb115 != null ? (tb115.getDesgNombre() != null ? tb115.getDesgNombre() : "")
						: "";

				Texto = Texto + (!nombreCalifica.equals("") ? nombreCalifica.trim() : objCte.FORMACION_LT_LI_A03);
			}
			
			dto.addLinea_003(Texto);

			dto.setLinea_004(this.sPre); // Centro/Instructor
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_004.length();
			Texto = objCte.FORMACION_LT_LI_004 + (new Util().getPuntos(iB));

			if (this.objFormacion.getCdgoCentroFor() != null) {
				Tbasg120CentformaDto tb120 = tbasg120CentformaService
						.findByCdgoCentrofor(this.objFormacion.getCdgoCentroFor());
				String nombreForma = tb120 != null ? (tb120.getDesgNombre() != null ? tb120.getDesgNombre().trim() : "") : "";
				Texto = Texto + (!nombreForma.equals("") ? nombreForma.trim() + " / " : objCte.FORMACION_LT_LI_A04 + " / ");
			}

			if (this.objFormacion.getCdgoIndinstr() != null) {
				Tbasg122InstruDto tb122 = tbasg122InstruService.findByCdgoNif(this.objFormacion.getCdgoIndinstr());
				String nombreInstru = tb122 != null ? (tb122.getDesgNombre() != null ? tb122.getDesgNombre().trim() : "") : "";
				Texto = Texto + (!nombreInstru.equals("") ? nombreInstru.trim() : objCte.FORMACION_LT_LI_A05);
			}
			dto.addLinea_004(Texto);
		}
		return dto;
	}

//	public void MIF_Init() {
//		ImprimirCts objCte = new ImprimirCts();
//
//		if (this.objFormacion != null)
//			Accion = true;
//
//		if (this.Accion) {
//			int iB = 0;
//			String Texto = "";
//
//			this.SetLinea_000(objCte.FORMACION_LT_LI_000);
//
//			this.SetLinea_001(this.sPre); // Curso - Codigo + descripcion
//			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_001.length();
//			Texto = objCte.FORMACION_LT_LI_001 + (new Util().getPuntos(iB));
//			
//			if (this.objFormacion.getCdgoCurso()!= null) {
//				Texto = Texto + (String) this.objFormacion.getCdgoCurso() + " - ";
//			}
//			
//			if (this.objFormacion.getDesgDesccurso() != null) {
//				Texto = Texto + (String) this.objFormacion.getDesgDesccurso();
//			}
//			this.AddLinea_001(Texto);
//
//			this.SetLinea_002(this.sPre); // Expediente/Fecha
//			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_002.length();
//			Texto = objCte.FORMACION_LT_LI_002 + (new Util().getPuntos(iB));
//			
//			if (this.objFormacion.getCodigo() != null) {
//				Texto = Texto + this.objFormacion.getCodigo().toString() + " / ";
//			} else {
//				Texto = Texto + objCte.FORMACION_LT_LI_A01 + " / ";
//			}
//			
//			if (this.objFormacion.getFchaCurso() != null) {
//				Texto = Texto + TextFormat.format((Date) this.objFormacion.getFchaCurso());
//			} else {
//				Texto = Texto + objCte.FORMACION_LT_LI_A02;
//			}
//			this.AddLinea_002(Texto);
//
//			this.SetLinea_003(this.sPre); // Tipo/Calificación
//			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_003.length();
//			Texto = objCte.FORMACION_LT_LI_003 + (new Util().getPuntos(iB));
//			
//			if (this.objFormacion.getDesgTipoCurso() != null) {
//				Texto = Texto + this.objFormacion.getDesgTipoCurso() + " / ";
//			} else {
//				Texto = Texto + objCte.FORMACION_LT_LI_A06 + " / ";
//				
//				if (this.objFormacion.getCdgoCalifi() != null) {
//					Tbasg115CalificacDto tb115 = this.tbasg115CalificacService
//							.findByCdgoCalifi(this.objFormacion.getCdgoCalifi());
//					String nombreCalifica = tb115 != null ? (tb115.getDesgNombre() != null ? tb115.getDesgNombre() : "")
//							: "";
//
//					Texto = Texto + (!nombreCalifica.equals("") ? nombreCalifica : objCte.FORMACION_LT_LI_A03);
//				}
//			}
//			this.AddLinea_003(Texto);
//
//			this.SetLinea_004(this.sPre); // Centro/Instructor
//			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACION_LT_LI_004.length();
//			Texto = objCte.FORMACION_LT_LI_004 + (new Util().getPuntos(iB));
//			
//			if (this.objFormacion.getCdgoCentroFor() != null) {
//				Tbasg120CentformaDto tb120 = tbasg120CentformaService
//						.findByCdgoCentrofor(this.objFormacion.getCdgoCentroFor());
//				String nombreForma = tb120 != null ? (tb120.getDesgNombre() != null ? tb120.getDesgNombre() : "") : "";
//				Texto = Texto + (!nombreForma.equals("") ? nombreForma + " / " : objCte.FORMACION_LT_LI_A04 + " / ");
//			}
//			
//			
//			if (this.objFormacion.getCdgoIndinstr() != null) {
//				Tbasg122InstruDto tb122 = tbasg122InstruService
//						.findByCdgoNif(this.objFormacion.getCdgoIndinstr());
//				String nombreInstru = tb122 != null ? (tb122.getDesgNombre() != null ? tb122.getDesgNombre() : "") : "";
//				Texto = Texto + (!nombreInstru.equals("") ? nombreInstru : objCte.FORMACION_LT_LI_A05);
//			}
//			this.AddLinea_004(Texto);
//		}
//	}

	public ActasPersonaDto getObjFormacion() {
		return objFormacion;
	}

	public void setObjFormacion(ActasPersonaDto objFormacion) {
		this.objFormacion = objFormacion;
	}
}
