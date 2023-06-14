package analizadorlexico;

public class Analizador {
    private AnalizadorLexico lex;
    private Token busca;
    Ent sup = null;
    int usado =0;

    public Analizador(AnalizadorLexico)throws IOException{
        lex = 1;
        mover();
    }

    void mover() throws IOException{
        busca = lex.escanear();
    }
    




}
