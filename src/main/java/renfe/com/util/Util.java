package renfe.com.util;

public class Util {
	
	public Util() {}
	
	public String getBlancos(int numero) { return(this.U_GetBlancos(numero)); }
	public String getPuntos(int numero)  { return(this.U_Puntos(numero)); }
	
	private String U_GetBlancos(int numero)
	{
		String sSalida = "";
		
		for(int i = 1; i<=numero; i++) sSalida = sSalida + " ";
		
		return(sSalida);
	}
	private String U_Puntos(int numero)
	{
		String sSalida = "";
		
		for(int i = 1; i<numero; i++) sSalida = sSalida + ".";
		sSalida = sSalida + " ";
		
		return(sSalida);
	}
	

	public static String quitarEspacios( Object str) {
	    return str == null ? ((String)"".trim()) : ((String) str).trim();
	}

	
}
