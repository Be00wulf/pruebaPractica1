package practicalfydp;

public class identificador {
    
    //leer la cadena
    public void analizar(String cadena){
        int est = 0, decimal = 0, tokenNum = 0;
        String estructura = "", tipo = "";
        String[] lineas = separador(cadena, '\n');
        
        for (int i = 0; i < lineas.length; i++) {       //linea
            for (int j = 0; j < lineas[i].length(); j++) {      //caracter
                int actual, siguiente = -1;
                actual = lineas[i].codePointAt(j);      //Devuelve codigo ASCII en la posición index pasada por parámetro
                if (est == 0) {
                    est = transicion(actual);
                }
                
                try {
                    siguiente = lineas[i].codePointAt(j+1);     //ascii
                } catch (Exception e) {
                    
                }
                
                switch(est){
                    case 1: 
                        estructura += lineas[i].charAt(j);
                        //minusculas ASCII 97-122
                        //mayusculas ASCII 65-90
                        if ((siguiente >= 97 && siguiente <= 122) || (siguiente >= 65 && siguiente <= 90)) {
                            est = 1;
                        }
                        else {
                            tokenNum = 1;
                            tipo = "     CADENA     ";
                            est = 0;
                        }
                        
                }
            }
        }
        
    }
    
    public  int transicion(int numero){
        //minusculas ASCII 97-122
        //mayusculas ASCII 65-90
        if ((numero >= 97 && numero <= 122) || (numero >= 65 && numero <= 90)) {
            return 1;
        }
        return 0;
    }
    
    //separar cadena`x
    public String[] separador(String palabra, char s3parar){
        String linea = "";
        int contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) == s3parar) {
                contador++;
            }
        }
        
        //agrefar el valor que se va hallando
        String[] cadenas = new String[contador];
        contador = 0;
        for (int i = 0; i < palabra.length(); i++) {
            if (palabra.charAt(i) != s3parar) {
                linea += String.valueOf(palabra.charAt(i));
            }
            else{
                cadenas[contador] = linea;
                contador++;
                linea = "";
            }
        }
        return cadenas;
    }
    
    
}//fin clase
