
package com.example.eccezioni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {


    Button leggi;
    Button scrivi;
    Button leggiRaw;
    Button leggiAssets;
    Button leggiJsonRaw;
    EditText nome;
    TextView txtFile;
    Gestore gest= new Gestore(); //istanza della classe Gestore, se non la istanzio non posso utilizzare i metodi della classe Gestore. Avrei un errore a runtime



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrivi= findViewById(R.id.scrivi); //recupero i riferimenti degli oggetti grafici
        leggi= findViewById(R.id.leggi);
        leggiRaw= findViewById(R.id.leggiRaw);
        leggiAssets= findViewById(R.id.leggiAssets);
        leggiJsonRaw= findViewById(R.id.jsonRaw);
        nome= findViewById(R.id.nomeFile);
        txtFile= findViewById(R.id.txtFile);


        scrivi.setOnClickListener(new View.OnClickListener() { //rende cliccabile il bottone scrivi
            @Override
            public void onClick(View v) {
                String esito= gest.scriviFile(nome.getText().toString(), getApplicationContext()); //assegno ad esito la stringa che ottengo eseguendo il metodo scriviFile a cui passo come parametri il nome del file (ottenuto dall'editText) e il contesto
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_LONG).show(); //visualizzo un toast con l'esito

            }
        });

        leggi.setOnClickListener(new View.OnClickListener() { //rende cliccabile il bottone leggi
            @Override
            public void onClick(View v) {
                Context c= getApplicationContext();
                String scritta= gest.leggiFile(nome.getText().toString(), c); //assegno a scritta la stringa che ottengo eseguendo il metodo leggiFile a cui passo come parametri il nome del file e il contesto
                txtFile.setText(scritta); //imposto scritta come testo visualizzato nella textView

            }
        });

        leggiRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c= getApplicationContext();
                String scritta= gest.leggiFileRaw(c);
                txtFile.setText(scritta);
            }
        });

        leggiAssets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c= getApplicationContext();
                String scritta= gest.leggiFileAssets(c);
                txtFile.setText(scritta);
            }
        });

        leggiJsonRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c= getApplicationContext();
                DatiBrano dati= null;
                try {
                    dati = gest.leggiJsonRaw(c);
                    txtFile.setText(dati.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}