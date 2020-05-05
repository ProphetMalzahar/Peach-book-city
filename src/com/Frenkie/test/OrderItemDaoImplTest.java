package com.Frenkie.test;

import com.Frenkie.dao.OrderItemDao;
import com.Frenkie.dao.impl.OrderItemDaoImpl;
import com.Frenkie.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao=new OrderItemDaoImpl();
        orderItemDao.saveOrderItem(new OrderItem(null,"Riddle Joker",1,new BigDecimal(99),new BigDecimal(99),"23456789"));
        orderItemDao.saveOrderItem(new OrderItem(null,"Riddle Joker",1,new BigDecimal(99),new BigDecimal(99),"23456789"));
    }
}