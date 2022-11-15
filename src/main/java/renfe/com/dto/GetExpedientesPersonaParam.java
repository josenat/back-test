package renfe.com.dto;

import java.math.BigInteger;

public class GetExpedientesPersonaParam {

    private Boolean indHistoric;
    private BigInteger codEstado;
    private String codAlcanceHab;
    private String tipoInfra;
    private BigInteger codTipoHabil;
    private Integer cdgoPersona;

    public Boolean getIndHistoric() {
        return indHistoric;
    }

    public void setIndHistoric(Boolean indHistoric) {
        this.indHistoric = indHistoric;
    }

    public BigInteger getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(BigInteger codEstado) {
        this.codEstado = codEstado;
    }

    public String getCodAlcanceHab() {
        return codAlcanceHab;
    }

    public void setCodAlcanceHab(String codAlcanceHab) {
        this.codAlcanceHab = codAlcanceHab;
    }

    public String getTipoInfra() {
        return tipoInfra;
    }

    public void setTipoInfra(String tipoInfra) {
        this.tipoInfra = tipoInfra;
    }

    public BigInteger getCodTipoHabil() {
        return codTipoHabil;
    }

    public void setCodTipoHabil(BigInteger codTipoHabil) {
        this.codTipoHabil = codTipoHabil;
    }

    public Integer getCdgoPersona() {
        return cdgoPersona;
    }

    public void setCdgoPersona(Integer cdgoPersona) {
        this.cdgoPersona = cdgoPersona;
    }
}
