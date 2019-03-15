package com.example.cart.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cart.R;
import com.example.cart.databinding.CartItemBinding;
import com.example.cart.model.Cart;

import java.util.List;

public class CartRecycleAdapter extends RecyclerView.Adapter<CartRecycleAdapter.CartViewHolder> {

    private List<Cart> mCarts;

    public CartRecycleAdapter(List<Cart> carts) {
        mCarts = carts;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        CartItemBinding binding = DataBindingUtil.inflate(inflater, R.layout.cart_item, viewGroup, false);
        return new CartViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder viewHolder, int i) {
        CartItemBinding binding = DataBindingUtil.bind(viewHolder.itemView);
        Cart cart = mCarts.get(i);
        binding.setCart(cart);
    }

    @Override
    public int getItemCount() {
        return mCarts != null ? mCarts.size() : 0;
    }

    public class CartViewHolder extends RecyclerView.ViewHolder{
        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
