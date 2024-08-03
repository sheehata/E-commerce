package com.example.ecomm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecomm.models.FakeStoreApi;
import com.example.ecomm.models.Product;
import com.example.ecomm.models.RecyclerviewAdapterH;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView recyclerViewh;
    private RecyclerviewAdapterH adapterH;
    private ProgressBar progress;
    private SearchView searchView;
    private List<Product> productList = new ArrayList<>();

    private void filterList(String query) {
        List<Product> filteredList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getTitle().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(product);
            }
        }
        adapterH.setProduct(filteredList);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        searchView = findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        progress = findViewById(R.id.progress);
        recyclerViewh = findViewById(R.id.homerv);
        adapterH = new RecyclerviewAdapterH();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewh.setLayoutManager(layoutManager);
        recyclerViewh.setAdapter(adapterH);
        searchView = findViewById(R.id.searchview);
        searchView.clearFocus();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(logging).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        FakeStoreApi apiInterface = retrofit.create(FakeStoreApi.class);

        Call<List<Product>> component = apiInterface.getProducts();

        component.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                progress.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    Log.e("isSuccessful", "onResponse: ");
                    productList = response.body();
                    adapterH.setProduct(productList);
                } else {
                    Log.e("Error", "Response not successful: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                progress.setVisibility(View.GONE);
                Log.e("Failure", "onFailure: ", t);
            }
        });
    }
}
