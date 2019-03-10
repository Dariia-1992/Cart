package com.example.cart.network;

import com.example.cart.model.Cart;

import java.util.List;

public interface CartLoadingListener {

    void startLoading();

    void finishLoading(List<Cart> carts);
}
