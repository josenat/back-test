/*
 * Creado el 29-sep-2009
 *
 * TODO Para cambiar la plantilla de este archivo generado, vaya a
 * Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de c�digo
 */
package renfe.com.pdf.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.ActasPersonaDto;
import renfe.com.pdf.beans.FormacionDossierPersonalBean;
import renfe.com.pdf.datamanager.MIFormacion;
import renfe.com.service.Tbasg100PersonaService;

/**
 * @author IGC RNF09-00005511
 *
 *         TODO Para cambiar la plantilla de este comentario generado, vaya a
 *         Ventana - Preferencias - Java - Estilo de c�digo - Plantillas de
 *         c�digo
 */
@Service
@Configurable
public class GetFormacion {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(GetFormacion.class);

	private Vector objFormacionDatos = null;
	private FormacionDossierPersonalBean objFormacionWriter[] = null;
	@Autowired
	private Tbasg100PersonaService tbasg100PersonaService;
	private int iCursos = 0;

	private Integer CdgoPersona;
	@Autowired
	private MIFormacion miFormacion;

	public GetFormacion() {
	}

	public boolean GetEstatus() {
		if (objFormacionDatos == null)
			return (false);
		else
			return (true);
	}

	public int GetCursos() {
		return (this.iCursos);
	}

	public String GetLinea_000(int Orden) {
		return (this.objFormacionWriter[Orden].getLinea_000());
	}

	public String GetLinea_001(int Orden) {
		return (this.objFormacionWriter[Orden].getLinea_001());
	}

	public String GetLinea_002(int Orden) {
		return (this.objFormacionWriter[Orden].getLinea_002());
	}

	public String GetLinea_003(int Orden) {
		return (this.objFormacionWriter[Orden].getLinea_003());
	}

	public String GetLinea_004(int Orden) {
		return (this.objFormacionWriter[Orden].getLinea_004());
	}

	public void GF_Init() {
		this.objFormacionDatos = this.cargaDatosFormacion(this.CdgoPersona.toString());

		this.iCursos = this.objFormacionDatos.size();

		this.objFormacionWriter = new FormacionDossierPersonalBean[this.iCursos];

		if (this.objFormacionDatos != null) {
			for (int i = 0; i < this.iCursos; i++) {

				miFormacion.setObjFormacion((ActasPersonaDto) this.objFormacionDatos.get(i));
				this.objFormacionWriter[i] = miFormacion.MIF_Init();
			}
		}
	}

	private Vector cargaDatosFormacion(String codPersona) {

		// Listado de datos de Formaci�n
		Vector vDatosFormacion = new Vector();
		if (null != codPersona && !"".equals(codPersona)) {
			List objGetActasPersonaAction = tbasg100PersonaService.getActasPersona(codPersona);
			vDatosFormacion = new Vector(objGetActasPersonaAction);
		}
		return vDatosFormacion;
	}

	public Integer getCdgoPersona() {
		return CdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		CdgoPersona = cdgoPersona;
	}

}
