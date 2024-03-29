package com.sj.skanercsv;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class PersistentStorage {

    static final String nazwa_pliku_z_danymi = "blueprints.txt";

    // metoda zapisująca produkty do pliku w pamięci telefonu
    public static void zapiszBlueprinty(ArrayList<FullBlueprint> blueprints, Context context) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(nazwa_pliku_z_danymi, Context.MODE_PRIVATE));
        for (FullBlueprint b : blueprints) {
            outputStreamWriter.write(b.toString());
        }
        outputStreamWriter.close();
    }

    // metoda wczytująca produkty z pliku w pamięci telefonu
    public static ArrayList<FullBlueprint> wczytajBlueprinty(Context context) throws IOException {
        InputStream inputStream = context.openFileInput(nazwa_pliku_z_danymi);
        if ( inputStream != null ) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String textLineFromFile = "";
            ArrayList<FullBlueprint> blueprints = new ArrayList<>();
            String tempName, tempBarcode, tempImgUri;

            int wczytaneBlueprinty = 0;
            while ((textLineFromFile = bufferedReader.readLine()) != null) {
                String[] blueprintInStringArray = textLineFromFile.split(";");
                if (blueprintInStringArray.length != 3) {
                    System.out.println("Nieprawidlowy blueprint nr " + (wczytaneBlueprinty + 1) + "w pliku data.txt!");
                    for (int i = 0; i < blueprintInStringArray.length; i++)
                        System.out.println("\"" + blueprintInStringArray[i] + "\"");
                } else {
                    tempName = blueprintInStringArray[0];
                    tempBarcode = blueprintInStringArray[1];
                    tempImgUri = blueprintInStringArray[2];
                    blueprints.add(new FullBlueprint(tempName, tempBarcode, tempImgUri));
                    System.out.println(blueprints.get(blueprints.size() - 1));
                    wczytaneBlueprinty++;
                }
            }

            System.out.println("Wczytano " + wczytaneBlueprinty + " linie z pliku data.txt");
            inputStream.close();
            return blueprints;
        } else {
            Toast.makeText(context, "Nie udało się wczytać danych z pliku data.txt!", Toast.LENGTH_LONG).show();
            throw new RuntimeException("Nie udalo sie wczytac danych z pliku data.txt");
        }
    }

}
