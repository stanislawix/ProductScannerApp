package com.sj.skanercsv;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BlueprintsAdapter extends RecyclerView.Adapter<BlueprintsAdapter.ViewHolder> {

    private List<FullBlueprint> mBlueprints;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView thumbnailImageView;
        private TextView nameTextView;
        private Button deleteButton;

        public ViewHolder(View view) {
            super(view);

            nameTextView = (TextView) view.findViewById(R.id.blueprintNameTextView);
            thumbnailImageView = (ImageView) view.findViewById(R.id.blueprintImageView);
            deleteButton = (Button) view.findViewById(R.id.deleteBlueprintButton);
        }

        public TextView getNameTextView() {
            return nameTextView;
        }
    }

    public BlueprintsAdapter(List<FullBlueprint> blueprints) {
        mBlueprints = blueprints;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BlueprintsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_blueprint_item, parent, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        FullBlueprint blueprint = mBlueprints.get(position);

        TextView nameTextView = viewHolder.nameTextView;
        nameTextView.setText(blueprint.getName());
        ImageView imageView = viewHolder.thumbnailImageView;
        imageView.setImageResource(R.drawable.ic_placeholder);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mBlueprints.size();
    }

}
