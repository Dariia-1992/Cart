package com.example.cart.network;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import com.example.cart.MainActivity;
import com.example.cart.database.CartDataBase;
import com.example.cart.model.Cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoadAsyncTask extends AsyncTask<Void, Void, List<Cart>> {

    public  static final String URL = "https://cartdatabase.firebaseio.com";

    private CartLoadingListener mLoadingListener;
    private Context mContext;

    public LoadAsyncTask(CartLoadingListener loadingListener, Context context) {
        mLoadingListener = loadingListener;
        mContext = context;
    }

   /* public LoadAsyncTask(Context context) {
        mContext = context;
    }*/

    @Override
    protected void onPreExecute() {
        if (mLoadingListener != null){
            mLoadingListener.startLoading();
        }
    }

    @Override
    protected List<Cart> doInBackground(Void... voids) {
        List<Cart> carts = null;
        CartDataBase cartDataBase = initializeDatabase();
        carts = cartDataBase.cartDao().getAll();

        if (carts == null || carts.size() == 0){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            CartService cartService = retrofit.create(CartService.class);
            try {
                Response<List<Cart>> response = cartService.getAllCarts().execute();
                carts = response.body();
                List<Cart> result = new ArrayList<>();
                for (Cart cart : carts){
                    if (cart != null){
                        result.add(cart);
                    }
                }
                carts = result;
                cartDataBase.cartDao().insertCart(carts);
            }
            catch (IOException exe){
                exe.printStackTrace();
            }
        }

        return carts;
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
