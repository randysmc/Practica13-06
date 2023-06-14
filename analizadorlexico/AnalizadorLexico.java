package analizadorlexico;
// Archivo AnalizadorLexico.java

import java.io.*;
import java.util.*;

public class AnalizadorLexico {
	public int linea = 1;
	private char vistazo = ' ';
	private Hashtable palabras = new Hashtable();

	void reservar(Palabra t) {

		palabras.put(t.lexema, t);

	}

	public AnalizadorLexico() {
		reservar(new Palabra(Etiqueta.TRUE, "true"));
		reservar(new Palabra(Etiqueta.FALSE, "false"));
		reservar(new Palabra(Etiqueta.IF, "if"));
		reservar(new Palabra(Etiqueta.ELSE, "else"));
		reservar(new Palabra(Etiqueta.WHILE, "while"));
		reservar(new Palabra(Etiqueta.SWITCH, "switch"));
		reservar(new Palabra(Etiqueta.CASE, "case"));
		reservar(new Palabra(Etiqueta.BREAK, "break"));
		
	}

	void readch() throws IOException {
		vistazo = (char) System.in.read();
	}

	boolean readch(char c) throws IOException{
		readch();
		if(vistazo != c) return false;
		vistazo = ' ';
		return true;
	}

	

	public Token explorar() throws IOException {

		for( ; ; readch()){
			if(vistazo == ' ' | vistazo == '\t') continue;
			else if(vistazo == '\n') linea = linea +1;
			else break;
		}

		/* 
		for (;; vistazo = (char) System.in.read()) {
			if (vistazo == ' ' || vistazo == '\t')
				continue;
			else if (vistazo == '\n')
				linea = linea + 1;
			else
				break;
		}*/

		if (Character.isDigit(vistazo)) {
			int v = 0;
			do {
				v = 10 * v + Character.digit(vistazo, 10);
				readch();
			} while (Character.isDigit(vistazo));

			if(vistazo != '.') return new Num(v);
			float x = v;
			float d=10;
			for(;;){
				readch();
				if(! Character.isDigit(vistazo)) break;
				x = x+ Character.digit(vistazo, 10) /d;
				d=d*10;
			}

			return new Real(v);
		}


		if (Character.isLetter(vistazo)) {
			StringBuffer b = new StringBuffer();
			do {
				b.append(vistazo);
				readch();
				//peek = (char) System.in.read();
			} while (Character.isLetterOrDigit(vistazo));
			String s = b.toString();
			Palabra w = (Palabra) palabras.get(s);
			if (w != null) return w;
			w = new Palabra(Etiqueta.ID, s);
			palabras.put(s, w);
			return w;
		}

		Token t = new Token(vistazo);
		vistazo = ' ';
		return t;
	}
}
