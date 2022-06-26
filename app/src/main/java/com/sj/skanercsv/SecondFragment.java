package com.sj.skanercsv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
import com.sj.skanercsv.databinding.FragmentSecondBinding;

import java.io.IOException;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    // rejestracja launchera aktywności odpowedzialnej za skanowanie kodu kreskowego i obsługe zwrotu zeskanowego Stringa
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Toast.makeText(getContext(), "Skanowanie anulowane", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "Zeskanowany kod: " + result.getContents(), Toast.LENGTH_LONG).show();
                    binding.blueprintBarcodeTextInputEditText.setText(result.getContents());
                }
            });

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        // ustawienie listenera na przycisk anulowania
        binding.buttonAnulujBlueprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        // ustawienie listenera na przycisk zatwierdzania
        binding.buttonZatwierdzBlueprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Zapisuję", Toast.LENGTH_LONG).show();
                String blueprintName = binding.blueprintNameTextInputEditText.getText().toString();
                String blueprintBarcode = binding.blueprintBarcodeTextInputEditText.getText().toString();
                String blueprintImgUri = "BRAK";
                FirstFragment.productBlueprints.add(new FullBlueprint(blueprintName, blueprintBarcode, blueprintImgUri));
                FirstFragment.blueprintsAdapter.notifyItemInserted(FirstFragment.blueprintsAdapter.getItemCount() -1);
                try {
                    PersistentStorage.zapiszBlueprinty(FirstFragment.productBlueprints, getContext());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        // ustawienie listenera na przycisk robienia zdjęcia (ten z ikonką aparatu)
        binding.addBlueprintPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Robię fotę", Toast.LENGTH_LONG).show();
            }
        });

        // ustawienie listenera na przycisk skanowania kodu kreskowego na końcu pola tekstowego
        binding.blueprintBarcodeTextInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Skanuję", Toast.LENGTH_LONG).show();
                skanujKod();
            }
        });

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // metoda odpowiedzialna za uruchamianie skanowania kodu kreskowego
    public void skanujKod() {
        ScanOptions options = new ScanOptions();
        options.setDesiredBarcodeFormats(ScanOptions.ALL_CODE_TYPES);
        options.setPrompt("Zeskanuj kod kreskowy produktu");
        options.setCameraId(0);
        options.setBeepEnabled(false);
        options.setBarcodeImageEnabled(false);
        options.setOrientationLocked(true);
        barcodeLauncher.launch(options);
    }

}