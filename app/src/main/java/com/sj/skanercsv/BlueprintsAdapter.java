package com.sj.skanercsv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BlueprintsAdapter extends RecyclerView.Adapter<BlueprintsAdapter.ViewHolder> {

    private List<FullBlueprint> mBlueprints; // lista produktów w adapterze, wyświetlana w RecyclerView

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnailImageView;
        private TextView nameTextView;
        private TextView barcodeTextView;
        private Button removeButton;

        public ViewHolder(View view) {
            super(view);

            nameTextView = (TextView) view.findViewById(R.id.blueprintNameTextView); // nazwa produktu
            barcodeTextView = (TextView) view.findViewById(R.id.blueprintBarcodeTextView); // kod kreskowy produktu
            thumbnailImageView = (ImageView) view.findViewById(R.id.blueprintImageView); // miniaturka produktu
            removeButton = (Button) view.findViewById(R.id.removeBlueprintButton); // przycisk usuwania produktu
        }

    }

    public BlueprintsAdapter(List<FullBlueprint> blueprints) {
        mBlueprints = blueprints;
    }

    // metoda tworząca nowe widoki pojedynczych produktów (wywoływana przez layout managera)
    @Override
    public BlueprintsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // tworzenie nowego widoku pojedynczego produktu w liście RecyclerView
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_blueprint_item, parent, false); // "pompowanie widoku"

        return new ViewHolder(view);
    }

    // metoda zastępująca zawartość widoku RecyclerView (wywoływana przez layout managera)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        FullBlueprint blueprint = mBlueprints.get(position);

        TextView nameTextView = viewHolder.nameTextView;
        TextView barcodeTextView = viewHolder.barcodeTextView;
        nameTextView.setText(blueprint.getName());
        barcodeTextView.setText(blueprint.getBarcode());
        ImageView imageView = viewHolder.thumbnailImageView;
        imageView.setImageResource(R.drawable.ic_placeholder);
        Button removeButton = viewHolder.removeButton;

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirstFragment.productBlueprints.remove(viewHolder.getAdapterPosition());
                FirstFragment.blueprintsAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

    }

    // metoda zwracająca rozmiar wbudowanej listy produktów (wywoływana przez layout managera)
    @Override
    public int getItemCount() {
        return mBlueprints.size();
    }

}
