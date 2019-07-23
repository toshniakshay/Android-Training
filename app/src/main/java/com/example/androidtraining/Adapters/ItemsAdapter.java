package com.example.androidtraining.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtraining.Models.Items;
import com.example.androidtraining.R;

import java.util.ArrayList;
import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {

    private Context context;
    private List<Items> items;

    public ItemsAdapter(Context context, List<Items> items) {
        this.context = context;
        if (items == null) {
            items = new ArrayList<>();
        }
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_view, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Items item = items.get(position);

        //TODO :: set values to items
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        //TODO :: bind values to items
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
