package com.example.cart.adapter;

import android.content.Context;
import android.database.Cursor;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import com.example.cart.R;
import com.example.cart.databinding.CartItemBinding;
import com.example.cart.model.Cart;
import com.squareup.picasso.Picasso;

public class CartAdapter extends CursorAdapter {

    public CartAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        CartItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.cart_item, parent, false);

        return binding.getRoot();
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        CartItemBinding binding = DataBindingUtil.bind(view);
        int id  = cursor.getInt(cursor.getColumnIndex(Cart.COLUMN_ID));
        String name = cursor.getString(cursor.getColumnIndex(Cart.COLUMN_NAME));
        String state = cursor.getString(cursor.getColumnIndex(Cart.COLUMN_STATE));
        double cost = cursor.getDouble(cursor.getColumnIndex(Cart.COLUMN_COST));
        String description = cursor.getString(cursor.getColumnIndex(Cart.COLUMN_DESCRIPTION));
        String imageUrl = cursor.getString(cursor.getColumnIndex(Cart.COLUMN_IMAGE_URL));

        Cart cart = new Cart();
        cart.setId(id);
        cart.setName(name);
        cart.setState(state);
        cart.setCost(cost);
        cart.setDescription(description);
        cart.setImageUrl(imageUrl);

        binding.setCart(cart);

    }
    @BindingAdapter("loadImageUrl")
    public static void setImageUrl(ImageView image, String url){
        Picasso.with(image.getContext()).load(url).into(image);
    }
}
