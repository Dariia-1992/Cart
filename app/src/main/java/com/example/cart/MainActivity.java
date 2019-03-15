package com.example.cart;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cart.adapter.CartRecycleAdapter;
import com.example.cart.model.Cart;
import com.example.cart.network.LoadAsyncTask;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private CartRecycleAdapter mRecycleAdapter;
    private SwipeRefreshLayout mSwipe;
    public static List<Cart> mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        mSwipe = findViewById(R.id.swipe);

        //LoadAsyncTask loadAsyncTask = new LoadAsyncTask(this, this);

    }
}
