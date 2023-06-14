package analizadorlexico;
// Archivo Palabra.java


public class Palabra extends Token {

	public String lexema = "";
					//cambiados
	public Palabra(int t, String s) {
		super(t); 
		lexema = new String(s);
	}

	public String toString(){
		return lexema;
	}

	public static final Palabra
	False = new Palabra(Etiqueta.FALSE, "False"),
	True = new Palabra(Etiqueta.TRUE, "True");

}