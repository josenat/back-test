package renfe.com.validator;

import java.sql.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidatorBase {

    private static char nifLetterTable[]= {
            'T','R','W','A','G','M','Y','F',
            'P','D','X','B','N','J','Z','S',
            'Q','V','H','L','C','K','E'
    };

    public static boolean mandatory(String value){

        if(value == null) return false;
        if(value.trim().equals("")) return false;
        return true;
    }

    public static boolean mandatory(double value){

        if(value <= 0.0 ) return false;
        return true;
    }

    public static boolean mandatory(Double value){

        if(value == null) return false;
        if(value.doubleValue() <= 0.0 ) return false;
        return true;
    }

    public static boolean mandatory(int value){

        if(value <= 0) return false;
        return true;
    }

    public static boolean mandatory(Integer value){

        if(value == null) return false;
        if(value.intValue() <= 0) return false;
        return true;
    }

    public static boolean mandatory(Date date){

        if(date == null) return false;
        return true;
    }

    public static boolean checkValue(List correctValues, String value){

        if(correctValues == null || correctValues.isEmpty()){
            return false;
        }

        return correctValues.contains(value);
    }

    public static boolean checkValue(List correctValues, Integer value){

        if(correctValues == null || correctValues.isEmpty()){
            return false;
        }

        return correctValues.contains(value);
    }

    public static boolean checkTlfn(Integer telefono){

        if(telefono == null || telefono.intValue() <= 0){
            return false;
        }
        if(telefono.toString().length() != 9){
            return false;
        }
        return true;
    }

    public static boolean checkNIF(String nif){

        String aux = nif.toUpperCase();
        Pattern pattern = Pattern.compile("[0-9]{8}[A-Z]{1}");
        Matcher matcher = pattern.matcher(aux);
        if(matcher.matches()){

            int digits = Integer.parseInt(aux.substring(0,8));
            char correctLetter =  nifLetterTable[digits % 23];
            char letter = aux.charAt(8);
            if(letter == correctLetter){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprobación NIE. Comience por X, Y o Z y después como el NIE,
     * con la salvedad de que son 7 dígitos para comprobar la letra.
     * @param nie
     * @return
     */
    public static boolean checkNIE(String nie)
    {
        String aux= nie.replace('-',' ').trim();
        aux = aux.toUpperCase();
        Pattern pattern = Pattern.compile("[XYZ]{1}[0-9]{7}[A-Z]{1}");
        Matcher matcher = pattern.matcher(aux);
        if(matcher.matches())
        {
            int digits = Integer.parseInt(aux.substring(1,8));
            char correctLetter =  nifLetterTable[digits % 23];
            char letter = aux.charAt(8);
            if(letter == correctLetter){
                return true;
            }
        }
        return false;
    }

    public static boolean checkCIF(String cif){

        Pattern pattern =
                Pattern.compile("([ABCDEFGHNPQSJUVWRabcdefghnpqsjuvwr])(\\d)(\\d)(\\d)(\\d)(\\d)(\\d)(\\d)([abcdefghijABCDEFGHIJ0123456789])");

        Matcher matcher = pattern.matcher(cif);
        if(matcher.matches()){

            //Sumamos las posiciones pares de los números centrales (en realidad posiciones 3,5,7 generales)
            int sumaPar = Integer.parseInt(matcher.group(3))+Integer.parseInt(matcher.group(5))+Integer.parseInt(matcher.group(7));

            //Multiplicamos por 2 las posiciones impares de los números centrales (en realidad posiciones 2,4,6,8 generales)
            //Y sumamos ambos digitos: el primer digito sale al dividir por 10 (es un entero y quedará 0 o 1)
            //El segundo dígito sale de modulo 10
            int sumaDigito2 = ((Integer.parseInt(matcher.group(2))*2)% 10)+((Integer.parseInt(matcher.group(2))*2)/ 10);
            int sumaDigito4 = ((Integer.parseInt(matcher.group(4))*2)% 10)+((Integer.parseInt(matcher.group(4))*2)/ 10);
            int sumaDigito6 = ((Integer.parseInt(matcher.group(6))*2)% 10)+((Integer.parseInt(matcher.group(6))*2)/ 10);
            int sumaDigito8 = ((Integer.parseInt(matcher.group(8))*2)% 10)+((Integer.parseInt(matcher.group(8))*2)/ 10);

            int sumaImpar = sumaDigito2 + sumaDigito4 + sumaDigito6 + sumaDigito8 ;

            int suma = sumaPar + sumaImpar;
            int control = 10 - (suma % 10);
            //La cadena comienza en el caracter 0, J es 0, no 10
            if (control == 10){
                control=0;
            }
            String letras = "JABCDEFGHI";

            //El dígito de control es una letra
            if (matcher.group(1).equalsIgnoreCase("K")
                    || matcher.group(1).equalsIgnoreCase("P")
                    || matcher.group(1).equalsIgnoreCase("Q")
                    || matcher.group(1).equalsIgnoreCase("S")) {

                if (matcher.group(9).equalsIgnoreCase(letras.substring(control,control+1)))
                    return true;
                else return false;

            } else if (matcher.group(1).equalsIgnoreCase("A") //El dígito de control es un número
                    || matcher.group(1).equalsIgnoreCase("B")
                    || matcher.group(1).equalsIgnoreCase("E")
                    || matcher.group(1).equalsIgnoreCase("H")) {

                if (matcher.group(9).equalsIgnoreCase(""+control))
                    return true;
                else return false;

            } else { //El dígito de control puede ser un número o una letra
                if (matcher.group(9).equalsIgnoreCase(letras.substring(control,control+1))
                        || matcher.group(9).equalsIgnoreCase(""+control))
                    return true;
                else return false;
            }
        }
        return false;
    }
}

