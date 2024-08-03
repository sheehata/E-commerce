package com.example.ecomm.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecomm.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerviewAdapterH extends RecyclerView.Adapter<RecyclerviewAdapterH.ComponentViewHolder> {

 private List<Product>components = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setProduct(List<Product> components) {
        this.components = components;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ComponentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_item, parent, false);
        ComponentViewHolder viewHolder = new ComponentViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ComponentViewHolder holder, int position) {
         Product c= components.get(position);
        Picasso.get().load(c.getImage()).into(holder.imageViewH);
         holder.textviewH.setText(c.getTitle());

    }

    @Override
    public int getItemCount() {
        return components.size();
    }

    //holder class for recyclerview
    static class ComponentViewHolder extends RecyclerView.ViewHolder{
        TextView textviewH;
        ImageView imageViewH;
        public ComponentViewHolder(@NonNull View itemView) {
            super(itemView);
            textviewH=itemView.findViewById(R.id.product_name);
            imageViewH=itemView.findViewById((R.id.product_image));
        }
    }


    }
