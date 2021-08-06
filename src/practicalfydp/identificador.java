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
                
            }
        }
        
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
