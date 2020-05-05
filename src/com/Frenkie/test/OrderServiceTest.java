package com.Frenkie.test;

import com.Frenkie.pojo.Cart;
import com.Frenkie.pojo.CartItem;
import com.Frenkie.service.OrderService;
import com.Frenkie.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

public class OrderServiceTest {

    @Test
    public void creatOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(3, "Riddle Joker", 1, new BigDecimal(99),new BigDecimal(99)));
        cart.addItem(new CartItem(2, "BLEACH", 1, new BigDecimal("18.8"),new BigDecimal("18.8")));
        cart.addItem(new CartItem(1, "海贼王", 1, new BigDecimal("18.8"),new BigDecimal("18.8")));

        OrderService orderService = new OrderServiceImpl();

        System.out.println( "订单号是：" + orderService.createOrder(cart, 1) );
    }
}