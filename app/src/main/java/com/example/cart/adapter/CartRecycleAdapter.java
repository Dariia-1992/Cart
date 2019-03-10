package com.example.cart.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cart.R;
import com.example.cart.model.Cart;

import java.util.List;

public class CartRecycleAdapter extends RecyclerView.Adapter<CartRecycleAdapter.ViewHolder> {

    private List<Cart> mCarts;

    @NonNull
    @Override
    public CartRecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CartRecycleAdapter.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mCarts != null ? mCarts.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

   /* class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mCartImage;
        TextView mCartName;
        TextView mCareState;
        TextView mCartCost;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mCartImage = itemView.findViewById(R.id.cart_image);
            mCartName = itemView.findViewById(R.id.cart_name);
            mCareState = itemView.findViewById(R.id.cart_state);
            mCartCost = itemView.findViewById(R.id.cart_cost);
        }
    }
}*/
