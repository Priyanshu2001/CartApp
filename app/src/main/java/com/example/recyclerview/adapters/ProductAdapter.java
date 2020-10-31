package com.example.recyclerview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.ProductItemBinding;
import com.example.recyclerview.models.Product;

import java.util.List;

//Adapter list of views
public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    //Needed for inflating Layout
    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context= context;
        this.productList=productList;
    }

    // inflate the view for item and create a viewHolder object
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //1. Inflate the the layout for product_item.xml
        ProductItemBinding b = ProductItemBinding.inflate(LayoutInflater.from(context),
                parent,
                false);

        //2. Create viewHolder Object and return
        return new ViewHolder(b);
    }


    // binds the data to view
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    Product product = productList.get(position);

    //Bind the data
        holder.b.name.setText(String.format("%s (Rs. %d)", product.name, product.price));
        //Quantity
        holder.b.quantity.setText(product.qty + "");

        //DecrementButton and Quantity TV Visibility
        holder.b.decrementBtn.setVisibility(product.qty > 0 ? View.VISIBLE : View.GONE);
        holder.b.quantity.setVisibility(product.qty > 0 ? View.VISIBLE : View.GONE);

        //Configure Buttons
        holder.b.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           product.qty++;
           notifyItemChanged(position);
            }
        });
        holder.b.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product.qty--;
                notifyItemChanged(position);
            }
        });
    }



    @Override
    public int getItemCount() {
        return 0;
    }

// holds the view foe each item
    public class ViewHolder extends RecyclerView.ViewHolder {
    ProductItemBinding b;
    public View itemView;

    public ViewHolder(@NonNull ProductItemBinding b) {
            super(b.getRoot());
        this.b = b;
    }
    }
}
