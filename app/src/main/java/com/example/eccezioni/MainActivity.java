
package com.example.eccezioni;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button leggi;
    Button scrivi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrivi= findViewById(R.id.scrivi);
        leggi= findViewById(R.id.leggi);
    }
}