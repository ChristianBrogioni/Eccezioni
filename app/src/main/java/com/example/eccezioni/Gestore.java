package com.example.eccezioni;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Gestore {

    private String nomeFile;

    public Gestore(String nomeFile){
        this.nomeFile= nomeFile;
    }

    public String leggiFile(String nomeFile, Context c){

        try{
            BufferedReader filein= new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile))); //trasforma uno stream di byte in uno stream di caratteri
        }
        catch(FileNotFoundException e){
            Log.e("classeGest", "Il file non esiste");
        }
        return "";
    }

    public String scriviFile(String nomeFile, Context c){

        FileOutputStream fileO;
        String frase= "Questo è ciò che scriviamo dentro il file";
        try {
            //apro il file
            fileO= c.openFileOutput(nomeFile, Context.MODE_PRIVATE);

            //scrivo il file
            fileO.write(frase.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

}

