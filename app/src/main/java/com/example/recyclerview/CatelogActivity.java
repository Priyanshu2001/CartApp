package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.recyclerview.databinding.ActivityCatelogBinding;
import com.example.recyclerview.models.Product;
import com.example.recyclerview.adapters.ProductAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatelogActivity extends AppCompatActivity {
        ActivityCatelogBinding catelogBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catelog);
        catelogBinding= ActivityCatelogBinding.inflate(getLayoutInflater());
        setContentView(catelogBinding.getRoot());

        setupProductList();
    }

    private void setupProductList() {
        // Create DataSet
        List<Product> products =new ArrayList<>(
                Arrays.asList(
                        new Product("Tomato",20)
                        , new Product("Potato", 30)
                        , new Product("Apple", 100)
                )

        );
        //Create Adapter object
        ProductAdapter adapter = new ProductAdapter(this, products);

        catelogBinding.recylerView.setAdapter(adapter);
        catelogBinding.recylerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
