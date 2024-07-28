package com.example.ecomm;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ecomm.models.Root;
import com.squareup.picasso.Picasso;

public class description extends AppCompatActivity {
    ImageView imageView;
    Root model;
    TextView t1;
    TextView t2;
    TextView t3 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        model = new Root("short","390","cotton quality","MEN","https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg");
        imageView =findViewById(R.id.product_image);
        t1=findViewById(R.id.product_description);
        t2=findViewById(R.id.product_colors);
        t3=findViewById(R.id.product_sizes);
        t1.setText(model.title);
        t2.setText(model.price);
        t3.setText(model.description);
       // imageView.setImageResource(model.image);
        Picasso.get().load(model.image).into(imageView);

    }
}