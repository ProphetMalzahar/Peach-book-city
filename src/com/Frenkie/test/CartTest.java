package com.Frenkie.test;

import com.Frenkie.pojo.Cart;
import com.Frenkie.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"星巴克与扑棱蛾子",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"星巴克与扑棱蛾子",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Riddle Joker",1,new BigDecimal(100),new BigDecimal(100)));
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"星巴克与扑棱蛾子",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"星巴克与扑棱蛾子",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Riddle Joker",1,new BigDecimal(100),new BigDecimal(100)));
        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"星巴克与扑棱蛾子",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1,"星巴克与扑棱蛾子",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2,"Riddle Joker",1,new BigDecimal(100),new BigDecimal(100)));
        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart=new Cart();
        cart.addItem(new CartItem(1,"星巴克与扑棱蛾子",1,new BigDecimal(1000),new BigDecimal(1000)));
        cart.updateCount(1,10);
        System.out.println(cart);
    }
}