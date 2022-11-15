package renfe.com.pdf.datamanager;

import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public abstract class TextFormat {
                  
    //private static final Locale locale = new Locale("es", "ES"); 
    
    public static String format(Date date){
        
        Calendar calAhora = Calendar.getInstance();
		calAhora.setTime(date);
		int niDia = calAhora.get(Calendar.DAY_OF_MONTH);
		
		// sumo uno al mes porque enero=0 ...
		int niMes = calAhora.get(Calendar.MONTH) + 1;
		int niAno = calAhora.get(Calendar.YEAR);
		
		String psSeparator = "-"; 
		return (fill(Integer.toString(niDia), 2, "0") + psSeparator 
		        + fill(Integer.toString(niMes), 2, "0") + psSeparator 
		        + Integer.toString(niAno));
    }
    
    public static String format(Date date, String separator){
        
        Calendar calAhora = Calendar.getInstance();
		calAhora.setTime(date);
		int niDia = calAhora.get(Calendar.DAY_OF_MONTH);
		
		// sumo uno al mes porque enero=0 ...
		int niMes = calAhora.get(Calendar.MONTH) + 1;
		int niAno = calAhora.get(Calendar.YEAR);
		 
		return (fill(Integer.toString(niDia), 2, "0") + separator 
		        + fill(Integer.toString(niMes), 2, "0") + separator 
		        + Integer.toString(niAno));
    }    
    
    public static String formatTime(Date date){
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
		
        int day = calendar.get(Calendar.DAY_OF_MONTH);		
		// sumo uno al mes porque enero = 0
		int month = calendar.get(Calendar.MONTH) + 1;
		int year = calendar.get(Calendar.YEAR);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		
		String dateSeparator = "-"; 
		String timeSeparator = ":";
		String zero = "0";
		return (fill(Integer.toString(day), 2, zero) + dateSeparator 
		        + fill(Integer.toString(month), 2, zero) + dateSeparator 
		        + Integer.toString(year)) + " "
				+ (hour < 10 ? (zero + hour) : Integer.toString(hour)) + timeSeparator
				+ (minute < 10 ? (zero + minute) : Integer.toString(minute)) + timeSeparator
				+ (second < 10 ? (zero + second) : Integer.toString(second));
    }    
    
    public static Date parseDate(String sDate)
	{
        StringTokenizer stFecha1;
        if (sDate.indexOf("-") > 0)
            stFecha1 = new StringTokenizer(sDate,"-");
        else
            stFecha1 = new StringTokenizer(sDate,"/");
		int niDia1 = Integer.parseInt(stFecha1.nextToken());
		int niMes1 = Integer.parseInt(stFecha1.nextToken())-1;
		int niAnio1 = Integer.parseInt(stFecha1.nextToken());
		Calendar calendar = new GregorianCalendar(niAnio1, niMes1, niDia1);
		return new Date(calendar.getTimeInMillis());
	}
    
    public static Date parseDateSeparator(String sDate, String separator)
	{
	    StringTokenizer stFecha1 = new StringTokenizer(sDate, separator);
		int niDia1 = Integer.parseInt(stFecha1.nextToken());
		int niMes1 = Integer.parseInt(stFecha1.nextToken())-1;
		int niAnio1 = Integer.parseInt(stFecha1.nextToken());
		Calendar calendar = new GregorianCalendar(niAnio1, niMes1, niDia1);
		return new Date(calendar.getTimeInMillis());
	}
    
    /**
	 *  Rota la fecha de entrada en formato dd-mm-yyyy a formato yyyy-mm-dd. 
	 *  Si el formato de la fecha de entrada no coincide con (dd-mm-yyyy) se 
	 *  devolvera la misma entrada
	 * @param psFecha fecha de entrada en formato dd-mm-yyyy
	 * @return String
	 */
	public static String parseDateDMA_AMD(String psFecha)
	{
		String sFechaVuelta = psFecha;
		StringTokenizer stFecha = new StringTokenizer(psFecha, "-");

		if ( (psFecha.length() == 10) && (stFecha.countTokens()>2) ) {
				
			String sDia = fill(stFecha.nextToken(), 2, "0");
			String sMes = fill(stFecha.nextToken(), 2, "0");
			String sAno = stFecha.nextToken();

			if (sDia.length() == 2 && sMes.length() == 2	&& sAno.length() == 4)
				sFechaVuelta = sAno + "-" + sMes + "-" + sDia;
		
			sAno = null;
			sMes = null;
			sDia = null;
			stFecha = null;
		}

		return sFechaVuelta;
	}
	
	/**
	 *  Rota la fecha de entrada en formato dd-mm-yyyy a formato yyyy-mm-dd-00.00.00.000. 
	 *  Si el formato de la fecha de entrada no coincide con (dd-mm-yyyy) se 
	 *  devolvera la misma entrada
	 * @param psFecha fecha de entrada en formato dd-mm-yyyy
	 * @return String
	 */
	public static String parseDateDMA_AMDHHMMdesde(String psFecha)
	{
	    StringBuffer sbFecha = new StringBuffer();
	    sbFecha.append(parseDateDMA_AMD(psFecha));
	    sbFecha.append("-00.00.00.000");

		return sbFecha.toString();
	}
	
	/**
	 *  Rota la fecha de entrada en formato dd-mm-yyyy a formato yyyy-mm-dd-23.59.59.999. 
	 *  Si el formato de la fecha de entrada no coincide con (dd-mm-yyyy) se 
	 *  devolvera la misma entrada
	 * @param psFecha fecha de entrada en formato dd-mm-yyyy
	 * @return String
	 */
	public static String parseDateDMA_AMDHHMMhasta(String psFecha)
	{
	    StringBuffer sbFecha = new StringBuffer();
	    sbFecha.append(parseDateDMA_AMD(psFecha));
	    sbFecha.append("-23.59.59.999");

		return sbFecha.toString();
	}
		
    /**
	 * Se utiliza para rellenar con el caracter psChar hasta la longitud "pniLong"
	 * lo que  venga en el string "psCadena"
	 * @param psCadena string a formatear
	 * @param pniLong longitud final del string
	 * @param psChar caracter utilizado para rellenar
	 * @return String Cadena rellena
	 */
	private static String fill(String psCadena, int pniLong, String psChar)
	{
		String res = psCadena;
		if (res == null)
			res = "";
		for (int i = res.length(); i < pniLong; i++)
		{
			res = psChar + res;
		}

		return res;
	}

	/**
	 *  Rota la fecha de entrada en formato yyyy-mm-dd a formato dd-mm-yyyy. 
	 *  Si el formato de la fecha de entrada no coincide con (yyyy-mm-dd) se 
	 *  devolvera la misma entrada
	 * @param psFecha fecha de entrada en formato yyyy-mm-dd
	 * @return String
	 */
	public static String getFechaVueltaAMD_DMA(String psFecha)
	{
		String sFechaVuelta = psFecha;
		StringTokenizer stFecha = new StringTokenizer(psFecha, "-");
		
		if ( (psFecha.length() == 10) && (stFecha.countTokens()>2) ) {

			String sAno = stFecha.nextToken();
			String sMes = fill(stFecha.nextToken(), 2, "0");
			String sDia = fill(stFecha.nextToken(), 2, "0");
			
			if (sDia.length() == 2 && sMes.length() == 2	&& sAno.length() == 4)
				sFechaVuelta = sDia + "-" + sMes + "-" + sAno;
				
			sAno = null;
			sMes = null;
			sDia = null;
			stFecha = null;
		} 
		
		return sFechaVuelta;
	}
	
	/**
	 *  Rota la fecha de entrada en formato yyyy-mm-dd-HH.MM.SS a formato dd-mm-yyyy
	 * @param psFecha
	 * @return String
	 */
	public static String getFechaVueltaAMD_DMA_Larga(String psFecha)
	{
		String sFechaVuelta = "";

		String sAno = psFecha.substring(0, 4);
		String sMes = psFecha.substring(5, 7);
		String sDia = psFecha.substring(8, 10);
			
		sFechaVuelta = sDia + "-" + sMes + "-" + sAno;

		return sFechaVuelta;
	}
}
