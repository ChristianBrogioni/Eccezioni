package com.example.eccezioni;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class Gestore {

    public String nomeFile;


    public String leggiFile(String nomeFile, Context c){

        StringBuilder sb= new StringBuilder(); //istanza oggetto StringBuilder chiamato sb, conterrà tutto il contenuto del file

        try{
            BufferedReader filein= new BufferedReader(new InputStreamReader(c.openFileInput(nomeFile))); //trasforma uno stream di byte in uno stream di caratteri
            String testoDaRestituire;
            while((testoDaRestituire=filein.readLine())!=null){ //Ciclo fino a quando il contenuto della riga non è null. Con il metodo readline leggo le righe del file
                sb.append(testoDaRestituire+"\n"); //se la riga è diversa da null aggiungo allo string builder il contenuto della riga
            }

        }
        catch(FileNotFoundException e){ //il file non potrebbe esistere e quindi si potrebbe generare un errore di tipo FileNotFound. Senza il catch il metodo openFileInput non funziona
            Log.e("Gestore", "Il file non esiste"); //messaggio log di tipo errore
        } catch (IOException e) { //c'è la possibilità che ci sia un IOException. Senza questo catch il metodo readLine non funziona
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
            fileO= c.openFileOutput(nomeFile, Context.MODE_PRIVATE); //apro il file in lettura utilizzando il metodo openFileOutput. Il primo parametro contiene il nome del file, il secondo parametro contiene il tipo di accesso, nel nostro caso privato

            //scrivo il file
            fileO.write(frase.getBytes()); //per scrivere il file abbiamo bisogno di lavorare con i bytes e quindi uso il metodo getBytes

            //chiudo il file
            fileO.close();
            esito= "File scritto correttamente";
        } catch (FileNotFoundException e) { //il file potrebbe non venir creato in alcuni casi (ad esempio nel caso in cui abbiamo la memoria piena) e quindi ci potrebbe essere un errore di tipo FileNotFound. Senza questo catch il metodo openFileOutput non funziona
            esito= "File non trovato";
        } catch (IOException e) { //c'è la possibilità che ci sia un IOException. Senza questo catch il metodo write non funziona
            esito= "Impossibile scrivere il file";
        }
        return esito;

    }

    public String leggiFileRaw(Context c){
        Resources res= c.getResources(); //andiamo nell'area della ram in cui è contenuta l'activity e più in particolare dove c'è il puntatore di res
        InputStream is= res.openRawResource(R.raw.brani); //l'eccezione non c'è perchè il file deve esistere, se non esiste mi da l'errore l'ide. Se gli passassi dinamicamente il nome del file otterrei un errore run time dato che è un'eccezione non controllata
        return "";
    }

    public String leggiFileAssets(Context c){
        AssetManager am= c.getAssets();
        try {
            InputStream is= am.open("brani.txt"); //in questo caso il file non ha un puntatore sulla ram, quindi se non creo un try e catch il metodo open mi genera un errore in quanto il nome del file inserito da noi programmatori potrebbe essere errato
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


}