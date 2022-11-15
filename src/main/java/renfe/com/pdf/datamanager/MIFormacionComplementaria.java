package renfe.com.pdf.datamanager;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;
import renfe.com.pdf.beans.FormacionCompDossierPersonalBean;
import renfe.com.util.ImprimirCts;
import renfe.com.util.Util;
@Service
@Configurable
public class MIFormacionComplementaria {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MIFormacionComplementaria.class);

	private GetFormacionComplementariaPersonaListResultDTO objFormacComplemen = null;
	private boolean modoTabulacion = false;

	private String sPre = "    ";
	private String sTabulacion = " ";

	public FormacionCompDossierPersonalBean MIT_Init() {
		int iB = 0;
		String Texto = "";
		ImprimirCts objCte = new ImprimirCts();
		FormacionCompDossierPersonalBean dto = new FormacionCompDossierPersonalBean();
		boolean Accion = false;

		if (this.objFormacComplemen != null)
			Accion = true;
		// Titulo
		dto.setLinea_000(objCte.FORMACCOMPLEMENT_LT_LI_000);
		// Se asigna una linea para indicar que no tiene Formación Complementaria, si
		// tiene se machaca.
		dto.setLinea_001(this.sPre + objCte.FORMACCOMPLEMENT_LT_LI_00B);

		if (Accion) {
			// Linea 1 - Categoría
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACCOMPLEMENT_LT_LI_001.length();
			Texto = objCte.FORMACCOMPLEMENT_LT_LI_001 + (new Util().getPuntos(iB));

			if (this.objFormacComplemen.getCategoria() != null)
				Texto = Texto + this.objFormacComplemen.getCategoria().trim();

			dto.setLinea_001(this.sPre);
			dto.addLinea_001(Texto);

			// Linea 2 - Cualificación
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACCOMPLEMENT_LT_LI_002.length();
			Texto = objCte.FORMACCOMPLEMENT_LT_LI_002 + (new Util().getPuntos(iB));

			if (this.objFormacComplemen.getCualificacion() != null)
				Texto = Texto + this.objFormacComplemen.getCualificacion().trim();

			dto.setLinea_002(this.sPre);
			dto.addLinea_002(Texto);

			// Linea 3 - Fecha de realización
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACCOMPLEMENT_LT_LI_003.length();
			Texto = objCte.FORMACCOMPLEMENT_LT_LI_003 + (new Util().getPuntos(iB));

			if (this.objFormacComplemen.getFechaExpedicion() != null) {
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				Texto = Texto + format.format(this.objFormacComplemen.getFechaExpedicion());
			}

			dto.setLinea_003(this.sPre);
			dto.addLinea_003(Texto);

			// Linea 4 - Observaciones
			iB = objCte.PERSONA_MAX_TITULO - objCte.FORMACCOMPLEMENT_LT_LI_004.length();
			Texto = objCte.FORMACCOMPLEMENT_LT_LI_004 + (new Util().getPuntos(iB));

			if (this.objFormacComplemen.getObservaciones() != null
					&& !this.objFormacComplemen.getObservaciones().equals(""))
				Texto = Texto + this.objFormacComplemen.getObservaciones().trim();
			else
				Texto = Texto + objCte.FORMACCOMPLEMENT_LT_LI_A01;

			dto.setLinea_004(this.sPre);
			dto.addLinea_004(Texto.trim());
		}
		return dto;
	}

	public GetFormacionComplementariaPersonaListResultDTO getObjFormacComplemen() {
		return objFormacComplemen;
	}

	public void setObjFormacComplemen(GetFormacionComplementariaPersonaListResultDTO objFormacComplemen) {
		this.objFormacComplemen = objFormacComplemen;
	}

	public boolean isModoTabulacion() {
		return modoTabulacion;
	}

	public void setModoTabulacion(boolean modoTabulacion) {
		this.modoTabulacion = modoTabulacion;
	}
}
