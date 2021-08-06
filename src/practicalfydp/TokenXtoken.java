package practicalfydp;

public class TokenXtoken {
//variables    
    private String palabra;
    private int tNumerico, fila, columna;
    private String tipo;
    
//constructor1
    public TokenXtoken() {
        
    }
    
//constructor2
    public TokenXtoken(String palabra, int tNumerico, int fila, int columna, String tipo) {
        this.palabra = palabra;
        this.tNumerico = tNumerico;
        this.fila = fila;
        this.columna = columna;
        this.tipo = tipo;
    }
    
//get set
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int gettNumerico() {
        return tNumerico;
    }

    public void settNumerico(int tNumerico) {
        this.tNumerico = tNumerico;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TokenXtoken{" + "palabra=" + palabra + ", tNumerico=" + tNumerico + ", fila=" + fila + ", columna=" + columna + ", tipo=" + tipo + '}';
    }
    
    
    
    
    
}//fin clase
