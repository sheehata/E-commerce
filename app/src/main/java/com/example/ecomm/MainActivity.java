package com.example.ecomm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecomm.models.FakeStoreApi;
import com.example.ecomm.models.Product;
import com.example.ecomm.models.ProductAdapter;
import com.example.ecomm.models.RetrofitClient;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchProducts();
    }

    private void fetchProducts() {
         FakeStoreApi api = RetrofitClient.getClient("https://fakestoreapi.com/ ").create(FakeStoreApi.class);
        Call<List<Product>> call = api.getProducts();// khdna instance mn retrofit w creatna beh api service

        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                if (response.isSuccessful()) {
                    List<Product> productList = response.body();
                    productAdapter = new ProductAdapter(MainActivity.this, productList);
                    recyclerView.setAdapter(productAdapter);
                }else {


                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
            }
        });
    }
}
