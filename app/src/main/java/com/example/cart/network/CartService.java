package com.example.cart.network;

import com.example.cart.model.Cart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CartService {

    @GET(".json")
    Call<List<Cart>> getAllCarts();
}
