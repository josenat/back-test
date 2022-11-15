package renfe.com.pdf.data;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg100PersonaDto;
import renfe.com.pdf.datamanager.MIPersona;
import renfe.com.service.Tbasg100PersonaService;

@Service
@Configurable
public class GetPersona {

	private static final Logger log = LoggerFactory.getLogger(GetPersona.class);
	@Autowired
	private Tbasg100PersonaService tbasg100PersonaService;
	@Autowired
	private MIPersona objPersonaWriter = null;

	private Tbasg100PersonaDto objPersonaDatos = null;

	private Integer CdgoPersona = new Integer(0);

	public GetPersona() {
	}

	protected void setCdgoPersona(Integer CdgoPersona) {
		if (this.objPersonaDatos != null)
			this.CdgoPersona = CdgoPersona;
	}

	public Integer getCdgoPersona() {
		return (this.CdgoPersona);
	}

	public boolean GetEstatus() {
		if (objPersonaDatos == null)
			return (false);
		else
			return (true);
	}

	public String GetLinea_000() {
		return (this.objPersonaWriter.GetLinea_000());
	}

	public String GetLinea_000B() {
		return (this.objPersonaWriter.GetLinea_000B());
	}

	public String GetLinea_001() {
		return (this.objPersonaWriter.GetLinea_001());
	}

	public String GetLinea_001B() {
		return (this.objPersonaWriter.GetLinea_001B());
	}

	public String GetLinea_001C() {
		return (this.objPersonaWriter.GetLinea_001C());
	}

	public String GetLinea_002() {
		return (this.objPersonaWriter.GetLinea_002());
	}

	public String GetLinea_003() {
		return (this.objPersonaWriter.GetLinea_003());
	}

	public String GetLinea_003B() {
		return (this.objPersonaWriter.GetLinea_003B());
	}

	public String GetLinea_003C() {
		return (this.objPersonaWriter.GetLinea_003C());
	}

	public String GetLinea_000C() {
		return (this.objPersonaWriter.GetLinea_000C());
	}

	public String GetLinea_004() {
		return (this.objPersonaWriter.GetLinea_004());
	}

	public String GetLinea_005() {
		return (this.objPersonaWriter.GetLinea_005());
	}

	public String GetLinea_006() {
		return (this.objPersonaWriter.GetLinea_006());
	}

	public void GP_Init(Integer CodPersona) {

//		try{ // Si lo que se le pasa es el documento
//			this.CdgoPersona  = (Integer) new GetPersonaByNifAction(Dato).execute();
//			if(this.CdgoPersona!=null) Dato = this.CdgoPersona.toString();
//		} catch(Exception Ex){
//            ExceptionDumper.dump(log, "ERROR Obteniendo Persona en Modulo Imprimir. Mirar por DNI ", Ex);
//		}
//		
		if (this.objPersonaDatos == null) {
			// Miro si lo que me han pasado es el codigo de persona
			try {
				this.objPersonaDatos = this.tbasg100PersonaService.findByCdgoPersona(CodPersona);
				this.setCdgoPersona(objPersonaDatos.getCdgoPersona());
			} catch (Exception Ex) {
				log.error("ERROR Obteniendo Persona en Modulo Imprimir. Mirar por Codigo Persona", Ex.getMessage());
				this.objPersonaDatos = null;
			}
		}

		if (this.objPersonaDatos != null) {
			this.objPersonaWriter.setObjPersona(objPersonaDatos);
			this.objPersonaWriter.MIP_Init();
		}
	}
}
