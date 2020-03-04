package com.razzaaq.fragmentsexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder> {
    private Context context;

    ListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.imageViewListItem.setImageResource(recipes.resourceIds[position]);
        holder.textViewListItem.setText(recipes.names[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,recipes.names[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.resourceIds.length;
    }

    static class Holder extends RecyclerView.ViewHolder {
        TextView textViewListItem;
        ImageView imageViewListItem;
        Holder(@NonNull View itemView) {
            super(itemView);
            textViewListItem = itemView.findViewById(R.id.textListName);
            imageViewListItem = itemView.findViewById(R.id.imageListItem);
        }
    }
}
