package com.example.prepare;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textView1;
    TextView textView2;
    ImageView imageView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.image);
        textView1=itemView.findViewById(R.id.name);
        textView2=itemView.findViewById(R.id.age);
    }
}
