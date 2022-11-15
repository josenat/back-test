package renfe.com.pdf.datamanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg101CertpsicDto;
import renfe.com.model.dto.Tbasg108CentmedicDto;
import renfe.com.model.dto.Tbasg109PsicoambiDto;
import renfe.com.model.dto.Tbasg110PsicomotiDto;
import renfe.com.model.dto.Tbasg111FacultatiDto;
import renfe.com.model.dto.Tbasg115CalificacDto;
import renfe.com.pdf.beans.CertificadoCompDossierPersonalBean;
import renfe.com.service.Tbasg101CertpsicService;
import renfe.com.service.Tbasg108CentmedicService;
import renfe.com.service.Tbasg109PsicoambiService;
import renfe.com.service.Tbasg110PsicomotiService;
import renfe.com.service.Tbasg111FacultatiService;
import renfe.com.service.Tbasg115CalificacService;
import renfe.com.util.ImprimirCts;
import renfe.com.util.Util;

@Service
@Configurable
public class MIPsicofisico {

	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(MIPsicofisico.class);

	private Tbasg101CertpsicDto objCertPsic = null;
	private boolean modoTabulacion = false;

	private String sPre = "    ";
	private String sTabulacion = " ";

	private String Linea_000 = "";
	private String Linea_001 = "";
	private String Linea_002 = "";
	private String Linea_003 = "";
	private String Linea_004 = "";
	@Autowired
	Tbasg101CertpsicService tbasg101CertpsicService;
	@Autowired
	Tbasg108CentmedicService tbasg108CentmedicService;
	@Autowired
	Tbasg109PsicoambiService tbasg109PsicoambiService;
	@Autowired
	Tbasg110PsicomotiService tbasg110PsicomotiService;
	@Autowired
	Tbasg111FacultatiService tbasg111FacultatiService;
	@Autowired
	Tbasg115CalificacService tbasg115CalificacService;

	public CertificadoCompDossierPersonalBean MIT_Init() {
		CertificadoCompDossierPersonalBean dto = new CertificadoCompDossierPersonalBean();
		int iB = 0;
		String Texto = "";
		ImprimirCts objCte = new ImprimirCts();
		Tbasg108CentmedicDto objCentMedic = null;
		Tbasg109PsicoambiDto objPsicoAmbi = null;
		Tbasg115CalificacDto objCalificac = null;
		Tbasg110PsicomotiDto objPsicoMoti = null;
		Tbasg111FacultatiDto objFacultati = null;

		boolean Accion = false;

		if (this.objCertPsic != null)
			Accion = true;

		// Titulo
		dto.setLinea_000(objCte.PSICOFISICO_LT_LI_000);
		// Se asigna una linea para indicar que no tiene Psicofisico, si tiene se
		// machaca.
		dto.setLinea_001(this.sPre + objCte.PSICOFISICO_LT_LI_00B);

		if (Accion) {
			// Linea 1 - Fechas Reconoimiento / Proxima Revision

			objPsicoMoti = this.tbasg110PsicomotiService.findByCdgoMotivo(this.objCertPsic.getCdgoMotivo());
			if (this.modoTabulacion) {
				iB = objCte.PERSONA_MAX_TITULO - objCte.PSICOFISICO_LT_LI_001.length() - this.sTabulacion.length();
				Texto = this.sTabulacion + objCte.PSICOFISICO_LT_LI_001 + (new Util().getPuntos(iB));
			} else {
				iB = objCte.PERSONA_MAX_TITULO - objCte.PSICOFISICO_LT_LI_001.length();
				Texto = objCte.PSICOFISICO_LT_LI_001 + (new Util().getPuntos(iB));
			}
			Texto = Texto + TextFormat.format(this.objCertPsic.getFchaReconoc()) + " / ";
			Texto = Texto + TextFormat.format(this.objCertPsic.getFchaProxrev()) + " / ";
			if (objPsicoMoti != null) {
				Texto = Texto + (objPsicoMoti.getDesgNombre()!=null?objPsicoMoti.getDesgNombre().trim():objPsicoMoti.getDesgNombre());			
			}

			dto.setLinea_001(this.sPre);
			dto.addLinea_001(Texto);

			// Linea 2 - Calificacion
			objCalificac = this.tbasg115CalificacService.findByCdgoCalifi(this.objCertPsic.getCdgoCalifi());

			if (this.modoTabulacion) {
				iB = objCte.PERSONA_MAX_TITULO - objCte.PSICOFISICO_LT_LI_002.length() - this.sTabulacion.length();
				Texto = this.sTabulacion + objCte.PSICOFISICO_LT_LI_002 + (new Util().getPuntos(iB));
			} else {
				iB = objCte.PERSONA_MAX_TITULO - objCte.PSICOFISICO_LT_LI_002.length();
				Texto = objCte.PSICOFISICO_LT_LI_002 + (new Util().getPuntos(iB));
			}

			if (objCalificac.getDesgNombre() != null) {
				Texto = Texto + objCalificac.getDesgNombre().trim();
			}

			dto.setLinea_002(this.sPre);
			dto.addLinea_002(Texto);

			// Linea 3 - Ambito de validez
			objPsicoAmbi = this.tbasg109PsicoambiService.findByCdgoPsicamb(this.objCertPsic.getCdgoPsicamb());

			iB = objCte.PERSONA_MAX_TITULO - objCte.PSICOFISICO_LT_LI_003.length();
			Texto = objCte.PSICOFISICO_LT_LI_003 + (new Util().getPuntos(iB));
			if (objPsicoAmbi.getDesgNombre() != null) {
				if (objPsicoAmbi.getDesgNombre().length() > objCte.MAX_CC_LINEA) {
					Texto = Texto + objPsicoAmbi.getDesgNombre().substring(0, (objCte.MAX_CC_LINEA - 3)) + "...";
				} else {
					Texto = Texto + objPsicoAmbi.getDesgNombre();
				}
			}

			dto.setLinea_003(this.sPre);
			dto.addLinea_003(Texto);

			// Linea 4 - Centro/Facultativo
			objCentMedic = this.tbasg108CentmedicService.findByCdgoCenmed(this.objCertPsic.getCdgoCenmed());
			objFacultati = this.tbasg111FacultatiService.findByCdgoFacult(this.objCertPsic.getCdgoFacult());

			// Trimeo el nombre del centro
			if (objFacultati != null) {
				objFacultati.setDesgNombre(objFacultati.getDesgNombre() != null ? objFacultati.getDesgNombre().trim()
						: objFacultati.getDesgNombre());
				objFacultati.setDesgApell1(objFacultati.getDesgApell1() != null ? objFacultati.getDesgApell1().trim()
						: objFacultati.getDesgApell1());
				objFacultati.setDesgApell2(objFacultati.getDesgApell2() != null ? objFacultati.getDesgApell2().trim()
						: objFacultati.getDesgApell2());
			}

			if (this.modoTabulacion) {
				iB = objCte.PERSONA_MAX_TITULO - objCte.PSICOFISICO_LT_LI_004.length() - this.sTabulacion.length();
				Texto = this.sTabulacion + objCte.PSICOFISICO_LT_LI_004 + (new Util().getPuntos(iB));
			} else {
				iB = objCte.PERSONA_MAX_TITULO - objCte.PSICOFISICO_LT_LI_004.length();
				Texto = objCte.PSICOFISICO_LT_LI_004 + (new Util().getPuntos(iB));
			}

			if (objCentMedic.getDesgNombre() != null) {
				Texto = Texto + objCentMedic.getDesgNombre().trim() + " / ";
			} else {
				Texto = Texto + objCte.PSICOFISICO_LT_LI_A04 + " / ";
			}

			if (objFacultati.getDesgNombre() != null) {
				String sPaso = objFacultati.getDesgApell1() + " " + objFacultati.getDesgApell2() + ", "
						+ objFacultati.getDesgNombre();
				if (sPaso.length() > objCte.MAX_CC_LINEA) {
					sPaso = sPaso.substring(0, (objCte.MAX_CC_LINEA - 3)) + "...";
				}
				Texto = Texto + sPaso;
			} else {
				Texto = Texto + objCte.PSICOFISICO_LT_LI_A14;
			}

			dto.setLinea_004(this.sPre);
			dto.addLinea_004(Texto);
		}
		return dto;
	}

	public Tbasg101CertpsicDto getObjCertPsic() {
		return objCertPsic;
	}

	public void setObjCertPsic(Tbasg101CertpsicDto objCertPsic) {
		this.objCertPsic = objCertPsic;
	}

	public boolean isModoTabulacion() {
		return modoTabulacion;
	}

	public void setModoTabulacion(boolean modoTabulacion) {
		this.modoTabulacion = modoTabulacion;
	}
}
