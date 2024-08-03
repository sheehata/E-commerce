package com.example.ecomm;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class description extends AppCompatActivity {
    private ImageView imageView;
    private TextView t1;
    private TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        imageView = findViewById(R.id.product_image);
        t1 = findViewById(R.id.product_title);
        t2 = findViewById(R.id.product_price);

        Intent intent = getIntent();
        if (intent != null) {
            String imageUrl = intent.getStringExtra("product_image");
            String title = intent.getStringExtra("product_title");
            String price = intent.getStringExtra("product_price");
            String description = intent.getStringExtra("product_description");

            t1.setText(title);
            t2.setText(price);



           //Picasso.get().load(imageUrl).into(imageView);
        }

    }
}
