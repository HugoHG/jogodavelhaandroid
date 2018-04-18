package br.com.senaijandira.jogodaforca;

/**
 * Created by 17170098 on 18/04/2018.
 */

public class Palavra {
    private String palavra;
    private String dica;

    public Palavra(String palavra, String dica){
        this.setPalavra(palavra);
        this.setDica(dica);
    }


    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String dica) {
        this.dica = dica;
    }
}
