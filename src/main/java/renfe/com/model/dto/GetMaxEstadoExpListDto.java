package renfe.com.model.dto;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import renfe.com.model.entity.Tbasg122Instru;

public class GetMaxEstadoExpListDto {

	private Integer CdgoExpedient;
	private Integer CdgoEstado;
	private Date FchaEstado;
	private Integer CdgoPersona;
	private String Estado;
	private String TipoHabilita;
	private String DesgPersona;
	private String DesgApell1;
	private String DesgApell2;
	private String DesgMatricula;
	private String DesgNifPass;
	private Integer CdgoTipoHab;
	private Integer CdgoAlcanceOt;
	private Integer CdgoEspec;
	private Integer CdgoAlcanceAmbito;
	private String DesgTipoInfraEstruc;
	private Integer CdgoEntorno;
	private String CdgoLinea;
	private String CdgoSerie;
	private String CdgoSubSerie;
	private String DesgObserva;
	private String DescSociedad;
	public Integer getCdgoExpedient() {
		return CdgoExpedient;
	}
	public void setCdgoExpedient(Integer cdgoExpedient) {
		CdgoExpedient = cdgoExpedient;
	}
	public Integer getCdgoEstado() {
		return CdgoEstado;
	}
	public void setCdgoEstado(Integer cdgoEstado) {
		CdgoEstado = cdgoEstado;
	}
	public Date getFchaEstado() {
		return FchaEstado;
	}
	public void setFchaEstado(Date fchaEstado) {
		FchaEstado = fchaEstado;
	}
	public Integer getCdgoPersona() {
		return CdgoPersona;
	}
	public void setCdgoPersona(Integer cdgoPersona) {
		CdgoPersona = cdgoPersona;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getTipoHabilita() {
		return TipoHabilita;
	}
	public void setTipoHabilita(String tipoHabilita) {
		TipoHabilita = tipoHabilita;
	}
	public String getDesgPersona() {
		return DesgPersona;
	}
	public void setDesgPersona(String desgPersona) {
		DesgPersona = desgPersona;
	}
	public String getDesgApell1() {
		return DesgApell1;
	}
	public void setDesgApell1(String desgApell1) {
		DesgApell1 = desgApell1;
	}
	public String getDesgApell2() {
		return DesgApell2;
	}
	public void setDesgApell2(String desgApell2) {
		DesgApell2 = desgApell2;
	}
	public String getDesgMatricula() {
		return DesgMatricula;
	}
	public void setDesgMatricula(String desgMatricula) {
		DesgMatricula = desgMatricula;
	}
	public String getDesgNifPass() {
		return DesgNifPass;
	}
	public void setDesgNifPass(String desgNifPass) {
		DesgNifPass = desgNifPass;
	}
	public Integer getCdgoTipoHab() {
		return CdgoTipoHab;
	}
	public void setCdgoTipoHab(Integer cdgoTipoHab) {
		CdgoTipoHab = cdgoTipoHab;
	}
	public Integer getCdgoAlcanceOt() {
		return CdgoAlcanceOt;
	}
	public void setCdgoAlcanceOt(Integer cdgoAlcanceOt) {
		CdgoAlcanceOt = cdgoAlcanceOt;
	}
	public Integer getCdgoEspec() {
		return CdgoEspec;
	}
	public void setCdgoEspec(Integer cdgoEspec) {
		CdgoEspec = cdgoEspec;
	}
	public Integer getCdgoAlcanceAmbito() {
		return CdgoAlcanceAmbito;
	}
	public void setCdgoAlcanceAmbito(Integer cdgoAlcanceAmbito) {
		CdgoAlcanceAmbito = cdgoAlcanceAmbito;
	}
	public String getDesgTipoInfraEstruc() {
        return DesgTipoInfraEstruc;
    }
    public void setDesgTipoInfraEstruc(String desgTipoInfraEstruc) {
        this.DesgTipoInfraEstruc = desgTipoInfraEstruc;
    }

	public Integer getCdgoEntorno() {
		return CdgoEntorno;
	}
	public void setCdgoEntorno(Integer cdgoEntorno) {
		CdgoEntorno = cdgoEntorno;
	}
	public String getCdgoLinea() {
		return CdgoLinea;
	}
	public void setCdgoLinea(String cdgoLinea) {
		CdgoLinea = cdgoLinea;
	}
	public String getCdgoSerie() {
		return CdgoSerie;
	}
	public void setCdgoSerie(String cdgoSerie) {
		CdgoSerie = cdgoSerie;
	}
	public String getCdgoSubSerie() {
		return CdgoSubSerie;
	}
	public void setCdgoSubSerie(String cdgoSubSerie) {
		CdgoSubSerie = cdgoSubSerie;
	}
	public String getDesgObserva() {
		return DesgObserva;
	}
	public void setDesgObserva(String desgObserva) {
		DesgObserva = desgObserva;
	}
	public String getDescSociedad() {
		return DescSociedad;
	}
	public void setDescSociedad(String descSociedad) {
		DescSociedad = descSociedad;
	}
	
}
	