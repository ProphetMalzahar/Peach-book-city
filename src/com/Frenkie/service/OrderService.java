package com.Frenkie.service;

import com.Frenkie.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
