package com.sj.skanercsv;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Datasource {

    public static ArrayList<FullBlueprint> loadProductBlueprints(Context context) {
        ArrayList<FullBlueprint> lista = new ArrayList<>();
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation1)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation2)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation3)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation4)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation5)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation6)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation7)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation8)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation9)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation10)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation1)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation2)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation3)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation4)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation5)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation6)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation7)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation8)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation9)));
        lista.add(new FullBlueprint(context.getResources().getString(R.string.affirmation10)));

        return lista;
    }
}
