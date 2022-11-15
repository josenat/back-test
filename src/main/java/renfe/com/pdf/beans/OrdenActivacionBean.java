package renfe.com.pdf.beans;

import java.util.HashMap;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class OrdenActivacionBean {

    @Autowired
	protected Logger logger;

	private String nifPas;
	private String matricula;
	private String nombreCompleto;
	private String areaActividad;
	private String cdgoReferenciaDoc;

	private HashMap hsDatoPlantDoc;
	private HashMap hsDocOrdenActiDato;
	private HashMap hsDocOrdenSuspDato;

    private String referenceNum;
    private String referenceYear;
    private String documentDate;
    private String subject;
    private String activationDate;
    private String activationReason;

    private String orderPersonName;
    private String orderPersonPosition;
    private String orderPersonDepartment;
    private Integer orderPersonCode;

    private String addresseeFirstName;
    private String addresseeName;
    private String addresseePosition;
    private String addresseeArea;    
    private Integer addresseeCode;

    private String territorialMgtResponsible;
    private String territorialMgtName;
    private String territorialMgtAddress;
    private Integer territorialMgtCode;

    private Integer activationArtCode;    

    public OrdenActivacionBean() {
        super();
        
        this.hsDatoPlantDoc = new HashMap<String, String>() {{
            put("hsDatoPlantDoc", "");
        }};

        this.hsDocOrdenActiDato = new HashMap<String, String>() {{
            put("hsDocOrdenActiDato", "");
        }};

        this.hsDocOrdenSuspDato = new HashMap<String, String>() {{
            put("hsDocOrdenSuspDato", "");
        }};                   
             
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
	 * @return Devuelve matricula.
	 */
	public String getMatricula() {
		return matricula;
	}
	/**
	 * @param matricula El matricula a establecer.
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	/**
	 * @return Devuelve nombreCompleto.
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	/**
	 * @param nombreCompleto El nombreCompleto a establecer.
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
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
	 * @return Devuelve hsDatoPlantDoc.
	 */
	public HashMap getHsDatoPlantDoc() {
		return hsDatoPlantDoc;
	}
	/**
	 * @param hsDatoPlantDoc El hsDatoPlantDoc a establecer.
	 */
	public void setHsDatoPlantDoc(HashMap hsDatoPlantDoc) {
		this.hsDatoPlantDoc = hsDatoPlantDoc;
	}
	/**
	 * @return Devuelve hsDocOrdenActiDato.
	 */
	public HashMap getHsDocOrdenActiDato() {
		return hsDocOrdenActiDato;
	}
	/**
	 * @param hsDocOrdenActiDato El hsDocOrdenActiDato a establecer.
	 */
	public void setHsDocOrdenActiDato(HashMap hsDocOrdenActiDato) {
		this.hsDocOrdenActiDato = hsDocOrdenActiDato;
	}
	/**
	 * @return Devuelve cdgoReferenciaDoc.
	 */
	public String getCdgoReferenciaDoc() {
		return cdgoReferenciaDoc;
	}
	/**
	 * @param cdgoReferenciaDoc El cdgoReferenciaDoc a establecer.
	 */
	public void setCdgoReferenciaDoc(String cdgoReferenciaDoc) {
		this.cdgoReferenciaDoc = cdgoReferenciaDoc;
	}
	/**
	 * @return Devuelve hsDocOrdenSuspDato.
	 */
	public HashMap getHsDocOrdenSuspDato() {
		return hsDocOrdenSuspDato;
	}
	/**
	 * @param hsDocOrdenSuspDato El hsDocOrdenSuspDato a establecer.
	 */
	public void setHsDocOrdenSuspDato(HashMap hsDocOrdenSuspDato) {
		this.hsDocOrdenSuspDato = hsDocOrdenSuspDato;
	}

    public String getReferenceNum() {
        return referenceNum;
    }

    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
    }

    public String getReferenceYear() {
        return referenceYear;
    }

    public void setReferenceYear(String referenceYear) {
        this.referenceYear = referenceYear;
    }

    public String getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(String documentDate) {
        this.documentDate = documentDate;  
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getActivationReason() {
        return activationReason;
    }

    public void setActivationReason(String activationReason) {
        this.activationReason = activationReason;
    }

    public String getOrderPersonName() {
        return orderPersonName;
    }

    public void setOrderPersonName(String orderPersonName) {
        this.orderPersonName = orderPersonName;
    }

	public String getOrderPersonPosition() {
        return orderPersonPosition;
    }

    public void setOrderPersonPosition(String orderPersonPosition) {
        this.orderPersonPosition = orderPersonPosition;
    }

    public String getOrderPersonDepartment() {
        return orderPersonDepartment;
    }

    public void setOrderPersonDepartment(String orderPersonDepartment) {
        this.orderPersonDepartment = orderPersonDepartment;
    } 
    
    public Integer getOrderPersonCode() {
        return orderPersonCode;
    }

    public void setOrderPersonCode(Integer orderPersonCode) {
        this.orderPersonCode = orderPersonCode;
    }    
        
    public String getAddresseeFirstName() {
        return addresseeFirstName;
    }

    public void setAddresseeFirstName(String addresseeFirstName) {
        this.addresseeFirstName = addresseeFirstName;
    }
    
    public String getAddresseeName() {
        return addresseeName;
    }

    public void setAddresseeName(String addresseeName) {
        this.addresseeName = addresseeName;
    }

    public String getAddresseePosition() {
        return addresseePosition;
    }

    public void setAddresseePosition(String addresseePosition) {
        this.addresseePosition = addresseePosition;
    }

    public String getAddresseeArea() {
        return addresseeArea;
    }

    public void setAddresseeArea(String addresseeArea) {
        this.addresseeArea = addresseeArea;
    }   
    
    public Integer getAddresseeCode() {
        return addresseeCode;
    }

    public void setAddresseeCode(Integer addresseeCode) {
        this.addresseeCode = addresseeCode;
    }    

	public String getTerritorialMgtResponsible() {
        return territorialMgtResponsible;
    }

    public void setTerritorialMgtResponsible(String territorialMgtResponsible) {
        this.territorialMgtResponsible = territorialMgtResponsible;
    }

    public String getTerritorialMgtName() {
        return territorialMgtName;
    }

    public void setTerritorialMgtName(String territorialMgtName) {
        this.territorialMgtName = territorialMgtName;
    }

    public String getTerritorialMgtAddress() {
        return territorialMgtAddress;
    }

    public void setTerritorialMgtAddress(String territorialMgtAddress) {
        this.territorialMgtAddress = territorialMgtAddress;
    }

    public Integer getTerritorialMgtCode() {
        return territorialMgtCode;
    }

    public void setTerritorialMgtCode(Integer territorialMgtCode) {
        this.territorialMgtCode = territorialMgtCode;
    }    

    public Integer getActivationArtCode() {
        return activationArtCode;
    }

    public void setActivationArtCode(Integer activationArtCode) {
        this.activationArtCode = activationArtCode;
    }    

}
