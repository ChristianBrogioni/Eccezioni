
package com.example.eccezioni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button leggi;
    Button scrivi;
    EditText nome;
    TextView txtFile;
    Gestore gest= new Gestore();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrivi= findViewById(R.id.scrivi);
        leggi= findViewById(R.id.leggi);
        nome= findViewById(R.id.nomeFile);
        txtFile= findViewById(R.id.txtFile);


        scrivi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String esito= gest.scriviFile(nome.getText().toString(), getApplicationContext());
                Toast.makeText(getApplicationContext(), esito, Toast.LENGTH_LONG).show();

            }
        });

        leggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context c= getApplicationContext();
                String percorso= c.getPackageResourcePath();
                String scritta= gest.leggiFile(nome.getText().toString(), c);
                txtFile.setText(scritta);

            }
        });
    }
}