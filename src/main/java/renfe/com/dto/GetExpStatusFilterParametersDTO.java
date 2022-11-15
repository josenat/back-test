package renfe.com.dto;

public class GetExpStatusFilterParametersDTO {

    private String documentId;
    private String tuitionDesc;
    private String firstName;
    private String lastName;
    private String secondName;
    private Integer societyId;
    private Integer activityAreaId;
    private Integer territorialAreaId;
    private String accountingCenterId;
    private Integer statusId;
    private Integer authTypeId;
    private Integer expedientId;

    private String cdgoEstadoRevocado;
    private String cdgoEstadoCerrado;
    private String cdgoEstadoTramitacion;
    private String cdgoEstadoVigente;

    public String getDocumentId() {
        return documentId;
    }
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getTuitionDesc() {
        return tuitionDesc;
    }
    public void setTuitionDesc(String tuitionDesc) {
        this.tuitionDesc = tuitionDesc;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public Integer getSocietyId() {
        return societyId;
    }
    public void setSocietyId(Integer societyId) {
        this.societyId = societyId;
    }
    public Integer getActivityAreaId() {
        return activityAreaId;
    }
    public void setActivityAreaId(Integer activityAreaId) {
        this.activityAreaId = activityAreaId;
    }
    public Integer getTerritorialAreaId() {
        return territorialAreaId;
    }
    public void setTerritorialAreaId(Integer territorialAreaId) {
        this.territorialAreaId = territorialAreaId;
    }
    public String getAccountingCenterId() {
        return accountingCenterId;
    }
    public void setAccountingCenterId(String accountingCenterId) {
        this.accountingCenterId = accountingCenterId;
    }
    public Integer getStatusId() {
        return statusId;
    }
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
    public Integer getAuthTypeId() {
        return authTypeId;
    }
    public void setAuthTypeId(Integer authTypeId) {
        this.authTypeId = authTypeId;
    } 

    public Integer getExpedientId() {
        return expedientId;
    }
    public void setExpedientId(Integer expedientId) {
        this.expedientId = expedientId;
    }    
    
    public String getCdgoEstadoRevocado() {
        return cdgoEstadoRevocado;
    }
    public void setCdgoEstadoRevocado(String cdgoEstadoRevocado) {
        this.cdgoEstadoRevocado = cdgoEstadoRevocado;
    }
    public String getCdgoEstadoCerrado() {
        return cdgoEstadoCerrado;
    }
    public void setCdgoEstadoCerrado(String cdgoEstadoCerrado) {
        this.cdgoEstadoCerrado = cdgoEstadoCerrado;
    }
    public String getCdgoEstadoTramitacion() {
        return cdgoEstadoTramitacion;
    }
    public void setCdgoEstadoTramitacion(String cdgoEstadoTramitacion) {
        this.cdgoEstadoTramitacion = cdgoEstadoTramitacion;
    }
    public String getCdgoEstadoVigente() {
        return cdgoEstadoVigente;
    }
    public void setCdgoEstadoVigente(String cdgoEstadoVigente) {
        this.cdgoEstadoVigente = cdgoEstadoVigente;
    }    
  
}
