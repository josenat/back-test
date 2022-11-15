package renfe.com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBASG185_REMITE_CARRIER_FNMT")
public class Tbasg185RemiteCarrierFnmt {

	@Id
	@Column(name = "CDGO_REMITE")
	private Long cdgoRemite;

	@NotNull
	@Column(name = "CARRIER_CARGORESPONSABLE")
	private String carrierCargoresponsable;

	@NotNull
	@Column(name = "CARRIER_RESPONSABLE")
	private String carrierResponsable;

	@NotNull
	@Column(name = "REMITE_LINEA1")
	private String remiteLinea1;

	@NotNull
	@Column(name = "REMITE_LINEA2")
	private String remiteLinea2;

	@NotNull
	@Column(name = "REMITE_LINEA3")
	private String remiteLinea3;

	@NotNull
	@Column(name = "REMITE_LINEA4")
	private String remiteLinea4;

	public Long getCdgoRemite() {
		return this.cdgoRemite;
	}

	public void setCdgoRemite(Long cdgoRemite) {
		this.cdgoRemite = cdgoRemite;
	}

	public String getCarrierCargoresponsable() {
		return this.carrierCargoresponsable;
	}

	public String getCarrierResponsable() {
		return this.carrierResponsable;
	}

	public String getRemiteLinea1() {
		return this.remiteLinea1;
	}

	public String getRemiteLinea2() {
		return this.remiteLinea2;
	}

	public String getRemiteLinea3() {
		return this.remiteLinea3;
	}

	public String getRemiteLinea4() {
		return this.remiteLinea4;
	}

	public void setCarrierCargoresponsable(String carrierCargoresponsable) {
		this.carrierCargoresponsable = carrierCargoresponsable;
	}

	public void setCarrierResponsable(String carrierResponsable) {
		this.carrierResponsable = carrierResponsable;
	}

	public void setRemiteLinea1(String remiteLinea1) {
		this.remiteLinea1 = remiteLinea1;
	}

	public void setRemiteLinea2(String remiteLinea2) {
		this.remiteLinea2 = remiteLinea2;
	}

	public void setRemiteLinea3(String remiteLinea3) {
		this.remiteLinea3 = remiteLinea3;
	}

	public void setRemiteLinea4(String remiteLinea4) {
		this.remiteLinea4 = remiteLinea4;
	}

}