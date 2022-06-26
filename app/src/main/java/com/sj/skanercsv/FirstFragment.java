package com.sj.skanercsv;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.sj.skanercsv.databinding.FragmentFirstBinding;

import java.io.IOException;
import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding; // wiązanie fragmentów
    protected static ArrayList<FullBlueprint> productBlueprints = new ArrayList<>(); // lista produktów
    protected static BlueprintsAdapter blueprintsAdapter;

    // metoda wywoływana przy tworzeniu widoku fragmentu
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        // "pompowanie" widoku fragmentu
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        // konstrukcja RecyclerView
        RecyclerView rvBlueprints = (RecyclerView) binding.listaBlueprintow;

        // dodawanie widocznego separatora między elementami wyświetlanymi w RV
        DividerItemDecoration hItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        Drawable mDivider = ContextCompat.getDrawable(getContext(), R.drawable.divider);
        hItemDecoration.setDrawable(mDivider);

        // wczytywanie produktów z pamięci i konfiguracja RV
        blueprintsAdapter = new BlueprintsAdapter(productBlueprints);
        rvBlueprints.setAdapter(blueprintsAdapter);
        rvBlueprints.setLayoutManager(new LinearLayoutManager(getContext()));
        rvBlueprints.addItemDecoration(hItemDecoration);

        // dodawanie listenera do przycisku z "+" do dodawania produktów
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

//        Toast.makeText(getContext(), "Creating View...", Toast.LENGTH_LONG).show();
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    // metoda wywoływana przy zatrzymywaniu/niszczeniu widoku
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // zapisywanie danych do pliku
        try {
            PersistentStorage.zapiszBlueprinty(FirstFragment.productBlueprints, getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        binding = null;
    }

    // metoda wywoływana przy tworzeniu fragmentu
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // wczytywanie danych z pliku
        try {
            productBlueprints = PersistentStorage.wczytajBlueprinty(getActivity().getApplicationContext());
            if(productBlueprints.size() > 5)
                Toast.makeText(getActivity().getApplicationContext(), "Udało się wczytać dane z pliku!", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getActivity().getApplicationContext(), "Nie udało się wczytać danych z pliku. Wypełnianie danymi domyślnymi", Toast.LENGTH_LONG).show();
            productBlueprints = Datasource.loadProductBlueprints();
        }

//        if(productBlueprints.isEmpty() || productBlueprints.size() < 8) {
        if(productBlueprints.isEmpty()) {
            Toast.makeText(getActivity().getApplicationContext(), "Wczytano zbyt mało danych z pliku. Wypełnianie danymi domyślnymi", Toast.LENGTH_LONG).show();
            productBlueprints = Datasource.loadProductBlueprints();
        }
    }
}