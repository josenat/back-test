package renfe.com.model.dto;

import java.sql.Date;

public class Tbasg101CertpsicDto {

	private String caducadoIlt;
	private Integer cdgoCalifi;
	private Integer cdgoCenmed;
	private Integer cdgoCertpsic;
	private String cdgoDeobs;
	private Integer cdgoFacult;
	private Integer cdgoMotivo;
	private Integer cdgoPersona;
	private Integer cdgoPsicamb;
	private String desgUsuact;
	private Date fchaAct;
	private Date fchaLimtemp;
	private Date fchaProxrev;
	private Date fchaReconoc;
	private String mrcaActivo;
	private String mrcaCorrvisual;
	private String mrcaProtaud;
	

	private Tbasg100PersonaDto Tbasg100Persona;
	private Tbasg108CentmedicDto tbasg108Centmedic;
	private Tbasg109PsicoambiDto tbasg109Psicoambi;
	private Tbasg110PsicomotiDto tbasg110Psicomoti;
	private Tbasg111FacultatiDto tbasg111Facultati;
	private Tbasg115CalificacDto tbasg115Calificac;


	public Tbasg100PersonaDto getTbasg100Persona() {
		return Tbasg100Persona;
	}

	public void setTbasg100Persona(Tbasg100PersonaDto tbasg100Persona) {
		Tbasg100Persona = tbasg100Persona;
	}

	public String getCaducadoIlt() {
		return this.caducadoIlt;
	}

	public void setCaducadoIlt(String caducadoIlt) {
		this.caducadoIlt = caducadoIlt;
	}

	public Integer getCdgoCalifi() {
		return this.cdgoCalifi;
	}

	public void setCdgoCalifi(Integer cdgoCalifi) {
		this.cdgoCalifi = cdgoCalifi;
	}

	public Integer getCdgoCenmed() {
		return this.cdgoCenmed;
	}

	public void setCdgoCenmed(Integer cdgoCenmed) {
		this.cdgoCenmed = cdgoCenmed;
	}

	public Integer getCdgoCertpsic() {
		return this.cdgoCertpsic;
	}

	public void setCdgoCertpsic(Integer cdgoCertpsic) {
		this.cdgoCertpsic = cdgoCertpsic;
	}

	public String getCdgoDeobs() {
		return this.cdgoDeobs;
	}

	public void setCdgoDeobs(String cdgoDeobs) {
		this.cdgoDeobs = cdgoDeobs;
	}

	public Integer getCdgoFacult() {
		return this.cdgoFacult;
	}

	public void setCdgoFacult(Integer cdgoFacult) {
		this.cdgoFacult = cdgoFacult;
	}

	public Integer getCdgoMotivo() {
		return this.cdgoMotivo;
	}

	public void setCdgoMotivo(Integer cdgoMotivo) {
		this.cdgoMotivo = cdgoMotivo;
	}

	public Integer getCdgoPersona() {
		return this.cdgoPersona;
	}

	public void setCdgoPersona(Integer cdgoPersona) {
		this.cdgoPersona = cdgoPersona;
	}

	public Integer getCdgoPsicamb() {
		return this.cdgoPsicamb;
	}

	public void setCdgoPsicamb(Integer cdgoPsicamb) {
		this.cdgoPsicamb = cdgoPsicamb;
	}

	public String getDesgUsuact() {
		return this.desgUsuact;
	}

	public void setDesgUsuact(String desgUsuact) {
		this.desgUsuact = desgUsuact;
	}

	public Date getFchaAct() {
		return this.fchaAct;
	}

	public void setFchaAct(Date fchaAct) {
		this.fchaAct = fchaAct;
	}

	public Date getFchaLimtemp() {
		return this.fchaLimtemp;
	}

	public void setFchaLimtemp(Date fchaLimtemp) {
		this.fchaLimtemp = fchaLimtemp;
	}

	public Date getFchaProxrev() {
		return this.fchaProxrev;
	}

	public void setFchaProxrev(Date fchaProxrev) {
		this.fchaProxrev = fchaProxrev;
	}

	public Date getFchaReconoc() {
		return this.fchaReconoc;
	}

	public void setFchaReconoc(Date fchaReconoc) {
		this.fchaReconoc = fchaReconoc;
	}

	public String getMrcaActivo() {
		return this.mrcaActivo;
	}

	public void setMrcaActivo(String mrcaActivo) {
		this.mrcaActivo = mrcaActivo;
	}

	public String getMrcaCorrvisual() {
		return this.mrcaCorrvisual;
	}

	public void setMrcaCorrvisual(String mrcaCorrvisual) {
		this.mrcaCorrvisual = mrcaCorrvisual;
	}

	public String getMrcaProtaud() {
		return this.mrcaProtaud;
	}

	public void setMrcaProtaud(String mrcaProtaud) {
		this.mrcaProtaud = mrcaProtaud;
	}

	public Tbasg108CentmedicDto getTbasg108Centmedic() {
		return tbasg108Centmedic;
	}

	public void setTbasg108Centmedic(Tbasg108CentmedicDto tbasg108Centmedic) {
		this.tbasg108Centmedic = tbasg108Centmedic;
	}

	public Tbasg109PsicoambiDto getTbasg109Psicoambi() {
		return tbasg109Psicoambi;
	}

	public void setTbasg109Psicoambi(Tbasg109PsicoambiDto tbasg109Psicoambi) {
		this.tbasg109Psicoambi = tbasg109Psicoambi;
	}

	public Tbasg110PsicomotiDto getTbasg110Psicomoti() {
		return tbasg110Psicomoti;
	}

	public void setTbasg110Psicomoti(Tbasg110PsicomotiDto tbasg110Psicomoti) {
		this.tbasg110Psicomoti = tbasg110Psicomoti;
	}

	public Tbasg111FacultatiDto getTbasg111Facultati() {
		return tbasg111Facultati;
	}

	public void setTbasg111Facultati(Tbasg111FacultatiDto tbasg111Facultati) {
		this.tbasg111Facultati = tbasg111Facultati;
	}

	public Tbasg115CalificacDto getTbasg115Calificac() {
		return tbasg115Calificac;
	}

	public void setTbasg115Calificac(Tbasg115CalificacDto tbasg115Calificac) {
		this.tbasg115Calificac = tbasg115Calificac;
	}

}