package com.sj.skanercsv;

import java.util.ArrayList;

public class Datasource {

    // metoda statyczna populująca listę produktów z kodu
    public static ArrayList<FullBlueprint> loadProductBlueprints() {
        ArrayList<FullBlueprint> lista = new ArrayList<>();
        lista.add(new FullBlueprint("Augustowianka Niegazowana 1,5L", "5901937000024"));
        lista.add(new FullBlueprint("Cisowianka Niegazowana 1,5L", "5908693759383"));
        lista.add(new FullBlueprint("Haribo Złote Misie 100gL", "5908395738493"));
        lista.add(new FullBlueprint("Prince Polo Classic XXL 50g", "5904947948329"));
        lista.add(new FullBlueprint("Tymbark Jabłko-Wiśnia 1L", "4028492384933"));
        lista.add(new FullBlueprint("Ryż biały Sante 400g", "4732847298743"));
        lista.add(new FullBlueprint("Ryż brązowy Sante 350g", "4732847298752"));
        lista.add(new FullBlueprint("Lubella Mlekołaki 500g", "5908389287842"));
        lista.add(new FullBlueprint("Kabanosy Tarczyński Drobiowe 105g", "5908230521508"));
        lista.add(new FullBlueprint("Cheetos 90g", "5902349829842"));
        lista.add(new FullBlueprint("Chipsy Lay's 140g", "5903920384283"));
        lista.add(new FullBlueprint("Fanta 1,5L", "5903862852861"));
        lista.add(new FullBlueprint("Sprite 1,5L", "5218952389909"));
        lista.add(new FullBlueprint("Coca-Cola 1,5L", "5902752858296"));

        return lista;
    }
}
