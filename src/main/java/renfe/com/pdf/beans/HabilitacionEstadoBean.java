package renfe.com.pdf.beans;

import java.util.HashSet;
import java.util.List;

public class HabilitacionEstadoBean {
    
    public static final int TIPO_ALC_INFRAESTRUCTURA_ENTORNO 	= 1;
    public static final int TIPO_ALC_INFRAESTRUCTURA_TRAMOS 	= 2;
    public static final int TIPO_ALC_INFRAESTRUCTURA_LINEA  	= 3;
    public static final int TIPO_ALC_MATERIAL  					= 4;
    public static final int TIPO_ALC_AUX_OPERACIONES  			= 5;
    public static final int TIPO_ALC_CARGADOR  					= 6;
    public static final int TIPO_ALC_OPERADOR_VEHIC_MANIOBRAS 	= 7;
    public static final int TIPO_RESPNSABLE_OP_CARGA 	        = 8;
    public static final int TIPO_ALC_AUXCAB_ALCANCE_AMP_ENTORNO = 9;
    public static final int TIPO_ALC_AUXCAB_ALCANCE_AMP_TRAMOS 	= 10;
    public static final int TIPO_ALC_AUXCAB_ALCANCE_AMP_LINEA  	= 11;
    public static final int TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_ENTORNO = 12;
    public static final int TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_TRAMOS 	= 13;
    public static final int TIPO_ALC_AOT_MANIOBRAS_AYUDACAB_LINEA  	= 14;
    public static final int TIPO_ALC_AUXILIAR_CABINA  	= 15;

    
    private String destinatario;    
    private String nifPas;
    private String nacionalidad;    
    private String areaActividad;
    private List listFechaValidez;
    private HashSet hsTiposHabil;
    private List listAlcance;
    private String nomTrabajador;
    //PPM103163 - Adaptación a orden ministerial – INICIO
    private String restrinRam;
    private int cdgoAreaAct;
  //PPM103163 - Adaptación a orden ministerial – FIN
    private String cdgoSociedad;
    
    private List listCodSociedades;
           
    public HabilitacionEstadoBean(){
    	super();
    }
    
    
    /**
     * @return Devuelve areaActividad.
     */
    public String getAreaActividad() {
        return areaActividad;
    }
    /**
     * @param areaActividad El areaActividad a establecer.
     */
    public void setAreaActividad(String areaActividad) {
        this.areaActividad = areaActividad;
    }
    /**
     * @return Devuelve destinatario.
     */
    public String getDestinatario() {
        return destinatario;
    }
    /**
     * @param destinatario El destinatario a establecer.
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }
    /**
     * @return Devuelve listFechaValidez.
     */
    public List getListFechaValidez() {
        return listFechaValidez;
    }
    /**
     * @param listFechaValidez El listFechaValidez a establecer.
     */
    public void setListFechaValidez(List listFechaValidez) {
        this.listFechaValidez = listFechaValidez;
    }
    /**
     * @return Devuelve nacionalidad.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }
    /**
     * @param nacionalidad El nacionalidad a establecer.
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    /**
     * @return Devuelve nifPas.
     */
    public String getNifPas() {
        return nifPas;
    }
    /**
     * @param nifPas El nifPas a establecer.
     */
    public void setNifPas(String nifPas) {
        this.nifPas = nifPas;
    }   
    /**
     * @return Devuelve listAlcance.
     */
    public List getListAlcance() {
        return listAlcance;
    }
    /**
     * @param listAlcance El listAlcance a establecer.
     */
    public void setListAlcance(List listAlcance) {
        this.listAlcance = listAlcance;
    }
    
    /**
     * @return Devuelve hsTiposHabil.
     */
    public HashSet getHsTiposHabil() {
        return hsTiposHabil;
    }
    /**
     * @param hsTiposHabil El hsTiposHabil a establecer.
     */
    public void setHsTiposHabil(HashSet hsTiposHabil) {
        this.hsTiposHabil = hsTiposHabil;
    }
    /**
     * @return Devuelve nomTrabajador.
     */
    public String getNomTrabajador() {
        return nomTrabajador;
    }
    /**
     * @param nomTrabajador El nomTrabajador a establecer.
     */
    public void setNomTrabajador(String nomTrabajador) {
        this.nomTrabajador = nomTrabajador;
    }
	public void setrestrinRam(String restrinRam) {
		this.restrinRam = restrinRam;
	}
	/**
	 * @return Devuelve nacionalidad.
	 */
	public String getrestrinRam() {
		return restrinRam;
	}	    
    /**
     * @param código de área de actividad a establecer.
     */
    public void setcdgoAreaAct(int cdgoAreaAct) {
        this.cdgoAreaAct = cdgoAreaAct;
    }

	/**
	 * @return Devuelve código de área de actividad.
	 */
	public int getcdgoAreaAct() {
		return cdgoAreaAct;
	}


	public String getCdgoSociedad() {
		return cdgoSociedad;
	}


	public void setCdgoSociedad(String cdgoSociedad) {
		this.cdgoSociedad = cdgoSociedad;
	}


	public List getListCodSociedades() {
		return listCodSociedades;
	}


	public void setListCodSociedades(List listCodSociedades) {
		this.listCodSociedades = listCodSociedades;
	}
	
	
	
}

