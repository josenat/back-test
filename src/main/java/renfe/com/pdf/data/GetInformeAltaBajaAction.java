package renfe.com.pdf.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Query;

import org.springframework.jdbc.object.SqlQuery;
import org.xml.sax.Attributes;

import ch.qos.logback.core.joran.action.Action;
import ch.qos.logback.core.joran.spi.ActionException;
import ch.qos.logback.core.joran.spi.InterpretationContext;
import renfe.com.util.DownloadPdfCts;


public class GetInformeAltaBajaAction extends Action{
	private Logger log = Logger.getLogger(GetInformeAltaBajaAction.class.getName());
	
	HashMap parametros;
	
	public GetInformeAltaBajaAction(HashMap parametros){
		super();	
        this.parametros = parametros;
    }
	
    public Object doExecute() throws Exception {    	
        // Variables
        List listaInforme = new ArrayList();
        List listaBajas = null;
        List listaAltas = null;
        
        if (this.parametros.get(DownloadPdfCts.PARAMETER_MERCANCIAS).equals("S"))
    		this.parametros.put("Mercancias", "S");        
        // Se ha seleccionado el check de altas, por lo que obtenemos el listado de personas
        // dadas de alta que cumplan con las fechas establecidas en la pantalla
        if (this.parametros.get(DownloadPdfCts.PARAMETER_ALTAS) != null && this.parametros.get(DownloadPdfCts.PARAMETER_ALTAS).equals("S")) {        	                
        	    //listaAltas = sqlMap.queryForList("Persona.findPersonaAltas",this.parametros);
        }
        // Se ha seleccionado el check de bajas
        if (this.parametros.get(DownloadPdfCts.PARAMETER_BAJAS) != null && this.parametros.get(DownloadPdfCts.PARAMETER_BAJAS).equals("S")) {
                      // listaBajas = sqlMap.("Persona.findPersonaBajas",this.parametros);
                       
        }
        
        // Agregamos la lista de altas y/o bajas
        if (listaAltas != null && !listaAltas.isEmpty()) {
                       listaInforme.addAll(listaAltas);
        }
        if (listaBajas != null && !listaBajas.isEmpty()) {
                       listaInforme.addAll(listaBajas);
        }
                       
        return listaInforme;       
  
    }

	@Override
	public void begin(InterpretationContext ic, String name, Attributes attributes) throws ActionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end(InterpretationContext ic, String name) throws ActionException {
		// TODO Auto-generated method stub
		
	}
}
