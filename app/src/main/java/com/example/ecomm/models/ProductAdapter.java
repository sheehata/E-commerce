package com.example.ecomm.models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ecomm.R;
import com.example.ecomm.description;
import com.example.ecomm.models.Product;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.titleTextView.setText(product.getTitle());
        holder.priceTextView.setText(product.getPrice());
        Picasso.get().load(product.getImage()).into(holder.imageView);
        // bb3at lel image el image
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, description.class);
            intent.putExtra("product_image", product.getImage());
            intent.putExtra("product_title", product.getTitle());
            intent.putExtra("product_price", product.getPrice());
            intent.putExtra("product_description", product.getDescription());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView priceTextView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.product_image);
            titleTextView = itemView.findViewById(R.id.product_title);
            priceTextView = itemView.findViewById(R.id.product_price);
        }
    }
}
//where is the class of the view holder
