package com.example.prepare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;
    private List<Detalis> detalis;

    public MyAdapter(Context context, List<Detalis> detalis) {
        this.context = context;
        this.detalis = detalis;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.design, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Detalis detail = detalis.get(position); // Corrected initialization of Detalis object
        holder.textView1.setText(detail.getName());
        holder.textView2.setText(String.valueOf(detail.getAge())); // Convert age to String if it's an int
        holder.imageView.setImageResource(detail.getImage());
    }

    @Override
    public int getItemCount() {
        return detalis.size();
    }
}
