package com.example.cart;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.cart.adapter.CartRecycleAdapter;
import com.example.cart.model.Cart;
import com.example.cart.network.CartLoadingListener;
import com.example.cart.network.LoadAsyncTask;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CartLoadingListener {

    private CartRecycleAdapter mRecycleAdapter;
    private SwipeRefreshLayout mSwipe;
    private  RecyclerView mRecyclerView;
    public static List<Cart> mList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);
        mSwipe = findViewById(R.id.swipe);

        LoadAsyncTask loadAsyncTask = new LoadAsyncTask(this);
        loadAsyncTask.execute();
    }

    @Override
    public void startLoading() {
        mRecyclerView.setVisibility(View.GONE);
    }

    @Override
    public void finishLoading(List<Cart> carts) {
        mRecyclerView.setVisibility(View.VISIBLE);
        mRecycleAdapter = new CartRecycleAdapter(carts);
        mRecyclerView.setAdapter(mRecycleAdapter);
    }
}
