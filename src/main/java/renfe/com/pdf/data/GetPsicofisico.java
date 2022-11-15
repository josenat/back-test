package renfe.com.pdf.data;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg101CertpsicDto;
import renfe.com.pdf.beans.CertificadoCompDossierPersonalBean;
import renfe.com.pdf.datamanager.MIPsicofisico;
import renfe.com.service.Tbasg101CertpsicService;

@Service
@Configurable
public class GetPsicofisico {

	private static final Logger log = LoggerFactory.getLogger(GetPsicofisico.class);

	private ArrayList objPsicofisicoDatos = null;
	private CertificadoCompDossierPersonalBean objPsicofisicoWriterVacio = null;
	private CertificadoCompDossierPersonalBean objPsicofisicoWriter[] = null;
	private Tbasg101CertpsicDto objPsicofisicoVacio = null;
	private Integer CdgoPersona = new Integer(0);
	@Autowired
	private Tbasg101CertpsicService tbasg101CertpsicService;

	private int iPsicofisicos = 0;

	public boolean GetEstatus() {
		if (objPsicofisicoDatos == null)
			return (false);
		else
			return (true);
	}

	public int GetNumPsicofisicos() {
		return (this.iPsicofisicos);
	}

	public String GetLinea_000() {
		return (this.objPsicofisicoWriterVacio.getLinea_000());
	}

	public String GetLinea_001() {
		return (this.objPsicofisicoWriterVacio.getLinea_001());
	}

	public String GetLinea_000(int Orden) {
		return (this.objPsicofisicoWriter[Orden].getLinea_000());
	}

	public String GetLinea_001(int Orden) {
		return (this.objPsicofisicoWriter[Orden].getLinea_001());
	}

	public String GetLinea_002(int Orden) {
		return (this.objPsicofisicoWriter[Orden].getLinea_002());
	}

	public String GetLinea_003(int Orden) {
		return (this.objPsicofisicoWriter[Orden].getLinea_003());
	}

	public String GetLinea_004(int Orden) {
		return (this.objPsicofisicoWriter[Orden].getLinea_004());
	}

	@Autowired
	MIPsicofisico mipsicofisico;

	public void GT_Init() {
		this.objPsicofisicoDatos = this.cargaDatosPsicofisicosL(this.CdgoPersona.toString());

		if (this.objPsicofisicoDatos != null) {

			this.iPsicofisicos = this.objPsicofisicoDatos.size();

			this.objPsicofisicoWriter = new CertificadoCompDossierPersonalBean[this.iPsicofisicos];

			if (this.objPsicofisicoDatos != null) {
				if (this.iPsicofisicos == 1) {
					this.mipsicofisico.setObjCertPsic((Tbasg101CertpsicDto) this.objPsicofisicoDatos.get(0));
					this.mipsicofisico.setModoTabulacion(false);
					this.objPsicofisicoWriter[0] = this.mipsicofisico.MIT_Init();
				} else {
					for (int i = 0; i < this.iPsicofisicos; i++) {
						this.mipsicofisico.setObjCertPsic((Tbasg101CertpsicDto) this.objPsicofisicoDatos.get(i));
						this.mipsicofisico.setModoTabulacion(true);
						this.objPsicofisicoWriter[i] = this.mipsicofisico.MIT_Init();
					}
				}
			}

		}
		this.mipsicofisico.setObjCertPsic(objPsicofisicoVacio);
		this.mipsicofisico.setModoTabulacion(false);
		this.objPsicofisicoWriterVacio = this.mipsicofisico.MIT_Init();
	}

	private ArrayList cargaDatosPsicofisicosL(String codPersona) {

		// Listado de datos de Psicofisicos
		ArrayList listPsicofisicos = null;
		if (null != codPersona && !"".equals(codPersona)) {
			listPsicofisicos = (ArrayList) this.tbasg101CertpsicService
					.getCertPsicByPerOrderPsicAmbFchaProxRev(codPersona);
		}
		return listPsicofisicos;
	}

	public Integer getCdgoPersona() {
		return CdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		CdgoPersona = cdgoPersona;
	}

}
