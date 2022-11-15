package renfe.com.dto;

public class GetIdiomasResultDTO {

	private Object cdgoIdioma;
    private Object desgIdioma;

    public Object getCdgoIdioma(){
        return cdgoIdioma;        
    }

	public void setCdgoIdioma (Object cdgoIdioma){
        this.cdgoIdioma = cdgoIdioma;
    }
    
    public Object getDesgIdioma(){
        return desgIdioma;        
    }

	public void setDesgIdioma (Object desgIdioma){
        this.desgIdioma = desgIdioma;
    }
    
}
