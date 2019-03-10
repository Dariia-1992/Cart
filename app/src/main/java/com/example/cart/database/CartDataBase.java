package com.example.cart.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.cart.model.Cart;

@Database(entities = {Cart.class}, version = 1, exportSchema = false)
public abstract class CartDataBase extends RoomDatabase {

    public abstract CartDao cartDao();
}
