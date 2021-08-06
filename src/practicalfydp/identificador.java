package practicalfydp;

import java.util.ArrayList;
 
public class identificador {
    ArrayList<TokenXtoken> listaTokens = new ArrayList();
    
    public identificador(ArrayList<TokenXtoken> listaTokens){
        this.listaTokens = listaTokens;
    }
    
    
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
                            tipo = "     IDENTIFICADOR     ";
                            est = 0;
                        }
                    break;
                    
                    case 2:
                        estructura += lineas[i].charAt(j);
                        if (siguiente > 47 && siguiente < 58) {     //numeros
                            est = 2;
                        }
                        else {
                            tokenNum = 2;
                            tipo = "     NUMERO ENTERO    ";
                            est = 0;
                        }
                    break;
                    
                    case 100:
                        est = -2;
                        break;
                        
                    case 999:   
                        estructura = String.valueOf(lineas[i].charAt(j));   //char a string
                        tokenNum = 999; 
                        tipo = "     ERROR     ";
                        est = 0;
                        break;
                }
                if (est == 0) {
                    listaTokens.add(new TokenXtoken(estructura, tokenNum, i+1, j+1, tipo));
                    estructura = "";
                    tipo = "";
                }
                
                if (est == -2) {
                    est = 0; 
                }
            }
        }
        
    }
    
    public  int transicion(int numero){
        //minusculas ASCII 97-122
        //mayusculas ASCII 65-90
        if ((numero >= 97 && numero <= 122) || (numero >= 65 && numero <= 90)) {
            return 1;
        }   else if (numero > 47 && numero < 58) {      //numeros ascii
            return 2;
            
        }
        else if (numero == 32 || numero == 13 || numero == 9) {        //32 => espacio ascii       13=>enter    9-> tab
            return 100;
        }
        else {
            return 999;
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
