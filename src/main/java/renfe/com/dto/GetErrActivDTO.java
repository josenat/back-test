package renfe.com.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class GetErrActivDTO {

	private Long cdgoError;
	private String cdgoCategoria;
	private String cdgoCtrocoste;
	private String cdgoDivision;
	private String cdgoPaisdir;
	private String cdgoPaisnac;
	private String cdgoPostal;
	private Integer cdgoProvincia;
	private String cdgoResidencia;
	private Integer cdgoTipoid;
	private String cdgoTipovia;
	private String desgApellido1;
	private String desgApellido2;
	private String desgAuxiliar;
	private String desgCategoria;
	private String desgDivision;
	private String desgError;
	private String desgFichero;
	private String desgId;
	private String desgMatricula;
	private String desgMunicipio;
	private String desgNacionalidad;
	private String desgNombre;
	private String desgNombrevia;
	private String desgNumero;
	private String desgPlanta;
	private String desgProvincia;
	private String desgPuerta;
	private String desgResidencia;
	private String desgUnidadpresup;
	private Date fchaAntigCargo;
	private Date fchaError;
	private Date fchaIngreso;
	private Date fchaNac;
	private String mrcaReprocesado;
	
	private String tipoIdNombre;
	private String paisNacNombre;
	private String tipoViaNombre;
	private String paisDirnombre;
	public Long getCdgoError() {
		return cdgoError;
	}
	public void setCdgoError(Long cdgoError) {
		this.cdgoError = cdgoError;
	}
	public String getCdgoCategoria() {
		return cdgoCategoria;
	}
	public void setCdgoCategoria(String cdgoCategoria) {
		this.cdgoCategoria = cdgoCategoria;
	}
	public String getCdgoCtrocoste() {
		return cdgoCtrocoste;
	}
	public void setCdgoCtrocoste(String cdgoCtrocoste) {
		this.cdgoCtrocoste = cdgoCtrocoste;
	}
	public String getCdgoDivision() {
		return cdgoDivision;
	}
	public void setCdgoDivision(String cdgoDivision) {
		this.cdgoDivision = cdgoDivision;
	}
	public String getCdgoPaisdir() {
		return cdgoPaisdir;
	}
	public void setCdgoPaisdir(String cdgoPaisdir) {
		this.cdgoPaisdir = cdgoPaisdir;
	}
	public String getCdgoPaisnac() {
		return cdgoPaisnac;
	}
	public void setCdgoPaisnac(String cdgoPaisnac) {
		this.cdgoPaisnac = cdgoPaisnac;
	}
	public String getCdgoPostal() {
		return cdgoPostal;
	}
	public void setCdgoPostal(String cdgoPostal) {
		this.cdgoPostal = cdgoPostal;
	}
	public Integer getCdgoProvincia() {
		return cdgoProvincia;
	}
	public void setCdgoProvincia(Integer cdgoProvincia) {
		this.cdgoProvincia = cdgoProvincia;
	}
	public String getCdgoResidencia() {
		return cdgoResidencia;
	}
	public void setCdgoResidencia(String cdgoResidencia) {
		this.cdgoResidencia = cdgoResidencia;
	}
	public Integer getCdgoTipoid() {
		return cdgoTipoid;
	}
	public void setCdgoTipoid(Integer cdgoTipoid) {
		this.cdgoTipoid = cdgoTipoid;
	}
	public String getCdgoTipovia() {
		return cdgoTipovia;
	}
	public void setCdgoTipovia(String cdgoTipovia) {
		this.cdgoTipovia = cdgoTipovia;
	}
	public String getDesgApellido1() {
		return desgApellido1;
	}
	public void setDesgApellido1(String desgApellido1) {
		this.desgApellido1 = desgApellido1;
	}
	public String getDesgApellido2() {
		return desgApellido2;
	}
	public void setDesgApellido2(String desgApellido2) {
		this.desgApellido2 = desgApellido2;
	}
	public String getDesgAuxiliar() {
		return desgAuxiliar;
	}
	public void setDesgAuxiliar(String desgAuxiliar) {
		this.desgAuxiliar = desgAuxiliar;
	}
	public String getDesgCategoria() {
		return desgCategoria;
	}
	public void setDesgCategoria(String desgCategoria) {
		this.desgCategoria = desgCategoria;
	}
	public String getDesgDivision() {
		return desgDivision;
	}
	public void setDesgDivision(String desgDivision) {
		this.desgDivision = desgDivision;
	}
	public String getDesgError() {
		return desgError;
	}
	public void setDesgError(String desgError) {
		this.desgError = desgError;
	}
	public String getDesgFichero() {
		return desgFichero;
	}
	public void setDesgFichero(String desgFichero) {
		this.desgFichero = desgFichero;
	}
	public String getDesgId() {
		return desgId;
	}
	public void setDesgId(String desgId) {
		this.desgId = desgId;
	}
	public String getDesgMatricula() {
		return desgMatricula;
	}
	public void setDesgMatricula(String desgMatricula) {
		this.desgMatricula = desgMatricula;
	}
	public String getDesgMunicipio() {
		return desgMunicipio;
	}
	public void setDesgMunicipio(String desgMunicipio) {
		this.desgMunicipio = desgMunicipio;
	}
	public String getDesgNacionalidad() {
		return desgNacionalidad;
	}
	public void setDesgNacionalidad(String desgNacionalidad) {
		this.desgNacionalidad = desgNacionalidad;
	}
	public String getDesgNombre() {
		return desgNombre;
	}
	public void setDesgNombre(String desgNombre) {
		this.desgNombre = desgNombre;
	}
	public String getDesgNombrevia() {
		return desgNombrevia;
	}
	public void setDesgNombrevia(String desgNombrevia) {
		this.desgNombrevia = desgNombrevia;
	}
	public String getDesgNumero() {
		return desgNumero;
	}
	public void setDesgNumero(String desgNumero) {
		this.desgNumero = desgNumero;
	}
	public String getDesgPlanta() {
		return desgPlanta;
	}
	public void setDesgPlanta(String desgPlanta) {
		this.desgPlanta = desgPlanta;
	}
	public String getDesgProvincia() {
		return desgProvincia;
	}
	public void setDesgProvincia(String desgProvincia) {
		this.desgProvincia = desgProvincia;
	}
	public String getDesgPuerta() {
		return desgPuerta;
	}
	public void setDesgPuerta(String desgPuerta) {
		this.desgPuerta = desgPuerta;
	}
	public String getDesgResidencia() {
		return desgResidencia;
	}
	public void setDesgResidencia(String desgResidencia) {
		this.desgResidencia = desgResidencia;
	}
	public String getDesgUnidadpresup() {
		return desgUnidadpresup;
	}
	public void setDesgUnidadpresup(String desgUnidadpresup) {
		this.desgUnidadpresup = desgUnidadpresup;
	}
	public Date getFchaAntigCargo() {
		return fchaAntigCargo;
	}
	public void setFchaAntigCargo(Date fchaAntigCargo) {
		this.fchaAntigCargo = fchaAntigCargo;
	}
	public Date getFchaError() {
		return fchaError;
	}
	public void setFchaError(Date fchaError) {
		this.fchaError = fchaError;
	}
	public Date getFchaIngreso() {
		return fchaIngreso;
	}
	public void setFchaIngreso(Date fchaIngreso) {
		this.fchaIngreso = fchaIngreso;
	}
	public Date getFchaNac() {
		return fchaNac;
	}
	public void setFchaNac(Date fchaNac) {
		this.fchaNac = fchaNac;
	}
	public String getMrcaReprocesado() {
		return mrcaReprocesado;
	}
	public void setMrcaReprocesado(String mrcaReprocesado) {
		this.mrcaReprocesado = mrcaReprocesado;
	}
	public String getTipoIdNombre() {
		return tipoIdNombre;
	}
	public void setTipoIdNombre(String tipoIdNombre) {
		this.tipoIdNombre = tipoIdNombre;
	}
	public String getPaisNacNombre() {
		return paisNacNombre;
	}
	public void setPaisNacNombre(String paisNacNombre) {
		this.paisNacNombre = paisNacNombre;
	}
	public String getTipoViaNombre() {
		return tipoViaNombre;
	}
	public void setTipoViaNombre(String tipoViaNombre) {
		this.tipoViaNombre = tipoViaNombre;
	}
	public String getPaisDirnombre() {
		return paisDirnombre;
	}
	public void setPaisDirnombre(String paisDirnombre) {
		this.paisDirnombre = paisDirnombre;
	}
	
}
