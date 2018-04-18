package br.com.senaijandira.jogodaforca;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<Palavra> listaPalavras = new ArrayList<>();
    ArrayList<Character> listaCaracteres = new ArrayList<>();
    ArrayList<String> listaUnderlines = new ArrayList<>();
    TextView txt_underlines;
    TextView txt_letra;
    TextView txt_dica;
    ImageView img;
    Integer numLetras;
    Integer numAcertos = 0;
    String underlines = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Find view by id*/
        txt_underlines = (TextView) findViewById(R.id.txt_underlines);
        txt_letra = (TextView) findViewById(R.id.txt_letra);
        txt_dica = (TextView) findViewById(R.id.txt_dica);
        img = (ImageView) findViewById(R.id.img);

        /*Adicionando palavras*/
        Palavra palavra = new Palavra("firsi", "primeira palavra cadastrada");
        listaPalavras.add(palavra);
        Palavra palavra2 = new Palavra("secone", "segunda palavra cadastrada");
        listaPalavras.add(palavra2);

        /*Sorteando uma palavra*/
        Random random = new Random();
        int x = random.nextInt(2);

        Palavra palavraSorteada = listaPalavras.get(x);

        numLetras = palavraSorteada.getPalavra().length();

        txt_dica.setText(palavraSorteada.getDica());

        /*Definindo as listas de caracteres*/
        for(int i = 0; i < numLetras; i++){
            listaCaracteres.add(palavraSorteada.getPalavra().charAt(i));
            listaUnderlines.add("_");
        }

        for (int i = 0; i < listaUnderlines.size(); i++){
            underlines = underlines + "_";
        }
        txt_underlines.setText(underlines);
    }

    public void verificar(View v){
        /*Pega a letra jogada e verifica se ela existe na palavra da vez*/
        String letraJogada = txt_letra.getText().toString();
        String palavraNaTela = txt_underlines.getText().toString();
        Log.d("letraJogada", letraJogada);
        Integer cont = 0;
        for(Character l : listaCaracteres) {
            if (letraJogada.equals(String.valueOf(l))) {
                listaUnderlines.set(cont, letraJogada);
                underlines = "";
                for(String u : listaUnderlines){
                    underlines = underlines + u;
                }
                txt_underlines.setText("");
                txt_underlines.setText(underlines);
                numAcertos++;
            }
            cont++;
        }
        if(numLetras == numAcertos){
            img.setVisibility(View.INVISIBLE);
            Log.d("ganhou", "ganhou!");
        }
        txt_letra.setText("");

        /**/

    }
}
