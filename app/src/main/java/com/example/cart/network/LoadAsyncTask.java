package com.example.cart.network;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.example.cart.database.CartDataBase;
import com.example.cart.model.Cart;

import java.util.List;

public class LoadAsyncTask extends AsyncTask<Void, Void, List<Cart>> {

    private CartLoadingListener mLoadingListener;
    private Context mContext;

    public LoadAsyncTask(CartLoadingListener loadingListener, Context context) {
        mLoadingListener = loadingListener;
        mContext = context;
    }

    @Override
    protected List<Cart> doInBackground(Void... voids) {
        List<Cart> carts = null;
        CartDataBase cartDataBase = initializeDatabase();
        carts = cartDataBase.cartDao().getAll();

        return null;
    }

    private CartDataBase initializeDatabase(){
        CartDataBase cartDataBase = Room.databaseBuilder(mContext,
                CartDataBase.class, "carts.db").build();
        return cartDataBase;
    }

    @Override
    protected void onPostExecute(List<Cart> carts) {
        if (mLoadingListener != null){
            mLoadingListener.finishLoading(carts);
        }
    }
}
