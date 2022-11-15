package renfe.com.dto;

public class GetTramoListByCdgoExpDTO {

    private Integer cdgoAlchabinf;
    private String cdgoLinea;
    private String desgNombreLinea;
    private String cdgoOrigen;
    private String Origen;
    private String cdgoDestino;
    private String Destino;
    private String desgNombreEstado;

    public Integer getCdgoAlchabinf() {
        return cdgoAlchabinf;
    }

    public void setCdgoAlchabinf(Integer cdgoAlchabinf) {
        this.cdgoAlchabinf = cdgoAlchabinf;
    }

    public String getCdgoLinea() {
        return cdgoLinea;
    }

    public void setCdgoLinea(String cdgoLinea) {
        this.cdgoLinea = cdgoLinea;
    }

    public String getDesgNombreLinea() {
        return desgNombreLinea;
    }

    public void setDesgNombreLinea(String desgNombreLinea) {
        this.desgNombreLinea = desgNombreLinea;
    }

    public String getCdgoOrigen() {
        return cdgoOrigen;
    }

    public void setCdgoOrigen(String cdgoOrigen) {
        this.cdgoOrigen = cdgoOrigen;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    public String getCdgoDestino() {
        return cdgoDestino;
    }

    public void setCdgoDestino(String cdgoDestino) {
        this.cdgoDestino = cdgoDestino;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public String getDesgNombreEstado() {
        return desgNombreEstado;
    }

    public void setDesgNombreEstado(String desgNombreEstado) {
        this.desgNombreEstado = desgNombreEstado;
    }
}
