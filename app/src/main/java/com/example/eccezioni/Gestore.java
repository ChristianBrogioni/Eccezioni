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

    public String nomeFile;

    public Gestore(String nomeFile){
        this.nomeFile= nomeFile;
    }

    public String leggiFile(String nomeFile, Context c){

        StringBuilder sb= new StringBuilder(); //istanza oggetto StringBuilder chiamato sb, conterrà tutto il contenuto del file

        try{
            BufferedReader filein= new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile))); //trasforma uno stream di byte in uno stream di caratteri
            String testoDaRestituire;
            while((testoDaRestituire=filein.readLine())!=null){
                sb.append(testoDaRestituire+"\n");
            }

        }
        catch(FileNotFoundException e){
            Log.e("Gestore", "Il file non esiste");
        } catch (IOException e) {
            Log.e("Gestore", "Impossibile leggere il file");
        }
        return sb.toString();
    }

    public String scriviFile(String nomeFile, Context c){

        String esito;
        FileOutputStream fileO;
        String frase= "Questo è ciò che scriviamo dentro il file";
        try {
            //apro il file
            fileO= c.openFileOutput(nomeFile, Context.MODE_PRIVATE); //secondo parametro: tipo di accesso, nel nostro caso privato

            //scrivo il file
            fileO.write(frase.getBytes());

            //chiudo il file
            fileO.close();
            esito= "File scritto correttamente";
        } catch (FileNotFoundException e) {
            esito= "File non trovato";
        } catch (IOException e) {
            esito= "Impossibile scrivere il file";
        }
        return esito;

    }

}

