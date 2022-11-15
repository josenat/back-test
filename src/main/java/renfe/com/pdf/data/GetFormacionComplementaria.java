package renfe.com.pdf.data;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.dto.GetFormacionComplementariaPersonaListResultDTO;
import renfe.com.pdf.beans.FormacionCompDossierPersonalBean;
import renfe.com.pdf.datamanager.MIFormacionComplementaria;
import renfe.com.service.Tbasg157FormacComplemenService;

@Service
@Configurable
public class GetFormacionComplementaria {

	private static final Logger log = LoggerFactory.getLogger(GetFormacionComplementaria.class);

	private ArrayList objFormacionComplementariaDatos = null;
	private GetFormacionComplementariaPersonaListResultDTO objFormacionComplementariaVacio = null;
	private FormacionCompDossierPersonalBean objFormacionComplementariaWriterVacio = null;
	private FormacionCompDossierPersonalBean objFormacionComplementariaWriter[] = null;
	@Autowired
	private Tbasg157FormacComplemenService tbasg157FormacComplemenService;
	private Integer CdgoPersona;
	@Autowired
	private MIFormacionComplementaria miFormacionComplementaria;
	private int iFormacComplement = 0;

	public GetFormacionComplementaria() {

	}

	public boolean GetEstatus() {
		if (objFormacionComplementariaDatos == null)
			return (false);
		else
			return (true);
	}

	public int GetNumFormacComplement() {
		return (this.iFormacComplement);
	}

	public String GetLinea_000() {
		return (this.objFormacionComplementariaWriterVacio.getLinea_000());
	}

	public String GetLinea_001() {
		return (this.objFormacionComplementariaWriterVacio.getLinea_001());
	}

	public String GetLinea_000(int Orden) {
		return (this.objFormacionComplementariaWriter[Orden].getLinea_000());
	}

	public String GetLinea_001(int Orden) {
		return (this.objFormacionComplementariaWriter[Orden].getLinea_001());
	}

	public String GetLinea_002(int Orden) {
		return (this.objFormacionComplementariaWriter[Orden].getLinea_002());
	}

	public String GetLinea_003(int Orden) {
		return (this.objFormacionComplementariaWriter[Orden].getLinea_003());
	}

	public String GetLinea_004(int Orden) {
		return (this.objFormacionComplementariaWriter[Orden].getLinea_004());
	}

	public void GT_Init() {
		this.objFormacionComplementariaDatos = this.cargaDatosFormacionComplementariaL(this.CdgoPersona);

		if (this.objFormacionComplementariaDatos != null) {

			this.iFormacComplement = this.objFormacionComplementariaDatos.size();

			this.objFormacionComplementariaWriter = new FormacionCompDossierPersonalBean[this.iFormacComplement];

			if (this.objFormacionComplementariaDatos != null) {
				if (this.iFormacComplement == 1) {
					this.miFormacionComplementaria.setObjFormacComplemen(
							(GetFormacionComplementariaPersonaListResultDTO) this.objFormacionComplementariaDatos
									.get(0));
					this.miFormacionComplementaria.setModoTabulacion(false);

					this.objFormacionComplementariaWriter[0] = this.miFormacionComplementaria.MIT_Init();
				} else {
					for (int i = 0; i < this.iFormacComplement; i++) {
						this.miFormacionComplementaria.setObjFormacComplemen(
								(GetFormacionComplementariaPersonaListResultDTO) this.objFormacionComplementariaDatos
										.get(0));
						this.miFormacionComplementaria.setModoTabulacion(true);

						this.objFormacionComplementariaWriter[i] = this.miFormacionComplementaria.MIT_Init();

					}
				}
			}

		}
		this.miFormacionComplementaria.setObjFormacComplemen(this.objFormacionComplementariaVacio);
		this.objFormacionComplementariaWriterVacio = this.miFormacionComplementaria.MIT_Init();
	}

	private ArrayList cargaDatosFormacionComplementariaL(Integer codPersona) {

		// Listado de datos de Formacion Complementaria
		ArrayList listFormacionComplementaria = null;
		if (null != codPersona && !"".equals(codPersona)) {
			try {
				listFormacionComplementaria = (ArrayList) tbasg157FormacComplemenService
						.getFormacComplemenPersonaList(codPersona, null, null);
			} catch (Exception e) {
				log.error("ERROR Carga Datos Formación Complementaria Modulo Imprimir ", e.getMessage());
			}
		}
		return listFormacionComplementaria;
	}

	public Integer getCdgoPersona() {
		return CdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		CdgoPersona = cdgoPersona;
	}

}
