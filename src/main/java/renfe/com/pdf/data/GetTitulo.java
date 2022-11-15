package renfe.com.pdf.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import renfe.com.model.dto.Tbasg102TituloconDto;
import renfe.com.pdf.datamanager.MITitulo;
import renfe.com.service.Tbasg102TituloconService;

@Service
@Configurable
public class GetTitulo {

	private static final Logger log = LoggerFactory.getLogger(GetTitulo.class);

	private Tbasg102TituloconDto objTituloConDatos = null;
	@Autowired
	private Tbasg102TituloconService tbasg102TituloconService;
	private MITitulo objTituloConWriter = null;

	private Integer CdgoPersona;

	public GetTitulo() {
	}

	public boolean GetEstatus() {
		if (objTituloConDatos == null)
			return (false);
		else
			return (true);
	}

	public String GetLinea_000() {
		return (this.objTituloConWriter.GetLinea_000());
	}

	public String GetLinea_001() {
		return (this.objTituloConWriter.GetLinea_001());
	}

	public void GT_Init() {
		try {
			this.objTituloConDatos = (Tbasg102TituloconDto) tbasg102TituloconService.getTituloConPersona(this.CdgoPersona.toString());
		} catch (Exception Ex) {
			log.error("ERROR Obteniendo Titulo de Conduccion Modulo Imprimir", Ex);
			return;
		}

		if (this.objTituloConDatos != null)
			this.objTituloConWriter = new MITitulo(this.objTituloConDatos);
	}

	public Integer getCdgoPersona() {
		return CdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		CdgoPersona = cdgoPersona;
	}
}
