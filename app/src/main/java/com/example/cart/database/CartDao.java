package com.example.cart.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.widget.AdapterView;

import com.example.cart.model.Cart;

import java.util.List;

@Dao
public interface CartDao {

   @Query("select * from Cart")
    List<Cart> getAll();

   @Query("select * from Cart")
    LiveData<List<Cart>> getLiveDataAll();

   @Query("select * from Cart where id=:cartId")
    LiveData<Cart> getCart(int cartId);

   @Insert
    void insertCart(List<Cart> carts);

   @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateCartPreferences(Cart cart);
}
