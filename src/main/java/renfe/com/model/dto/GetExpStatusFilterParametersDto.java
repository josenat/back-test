package renfe.com.model.dto;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.beanutils.BeanUtils;

import renfe.com.model.entity.Tbasg122Instru;

public class GetExpStatusFilterParametersDto {

	private Integer StatusId;
	private String DocumentId;
	private String TuitionDesc;
	private String FirstName;
	private String LastName;
	private String SecondName;
	private String SocietyId;
	private Integer ActivityAreaId;
	private Integer TerritorialAreaId;
	private Integer AccountingCenterId;
	private Integer AuthTypeId;
	private Integer ExpedientId;
	private Integer CdgoEstadoRevocado;
	private Integer CdgoEstadoCerrado;
	private Integer CdgoEstadoTramitacion;
	private Integer CdgoEstadoVigente;
	public Integer getStatusId() {
		return StatusId;
	}
	public void setStatusId(Integer statusId) {
		StatusId = statusId;
	}
	public String getDocumentId() {
		return DocumentId;
	}
	public void setDocumentId(String documentId) {
		DocumentId = documentId;
	}
	public String getTuitionDesc() {
		return TuitionDesc;
	}
	public void setTuitionDesc(String tuitionDesc) {
		TuitionDesc = tuitionDesc;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getSecondName() {
		return SecondName;
	}
	public void setSecondName(String secondName) {
		SecondName = secondName;
	}
	public String getSocietyId() {
		return SocietyId;
	}
	public void setSocietyId(String societyId) {
		SocietyId = societyId;
	}
	public Integer getActivityAreaId() {
		return ActivityAreaId;
	}
	public void setActivityAreaId(Integer activityAreaId) {
		ActivityAreaId = activityAreaId;
	}
	public Integer getTerritorialAreaId() {
		return TerritorialAreaId;
	}
	public void setTerritorialAreaId(Integer territorialAreaId) {
		TerritorialAreaId = territorialAreaId;
	}
	public Integer getAccountingCenterId() {
		return AccountingCenterId;
	}
	public void setAccountingCenterId(Integer accountingCenterId) {
		AccountingCenterId = accountingCenterId;
	}
	public Integer getAuthTypeId() {
		return AuthTypeId;
	}
	public void setAuthTypeId(Integer authTypeId) {
		AuthTypeId = authTypeId;
	}
	public Integer getExpedientId() {
		return ExpedientId;
	}
	public void setExpedientId(Integer expedientId) {
		ExpedientId = expedientId;
	}
	public Integer getCdgoEstadoRevocado() {
		return CdgoEstadoRevocado;
	}
	public void setCdgoEstadoRevocado(Integer cdgoEstadoRevocado) {
		CdgoEstadoRevocado = cdgoEstadoRevocado;
	}
	public Integer getCdgoEstadoCerrado() {
		return CdgoEstadoCerrado;
	}
	public void setCdgoEstadoCerrado(Integer cdgoEstadoCerrado) {
		CdgoEstadoCerrado = cdgoEstadoCerrado;
	}
	public Integer getCdgoEstadoTramitacion() {
		return CdgoEstadoTramitacion;
	}
	public void setCdgoEstadoTramitacion(Integer cdgoEstadoTramitacion) {
		CdgoEstadoTramitacion = cdgoEstadoTramitacion;
	}
	public Integer getCdgoEstadoVigente() {
		return CdgoEstadoVigente;
	}
	public void setCdgoEstadoVigente(Integer cdgoEstadoVigente) {
		CdgoEstadoVigente = cdgoEstadoVigente;
	}
	

	
}