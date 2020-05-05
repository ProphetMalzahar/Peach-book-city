package com.Frenkie.test;

import com.Frenkie.dao.OrderDao;
import com.Frenkie.dao.impl.OrderDaoImpl;
import com.Frenkie.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao=new OrderDaoImpl();
        orderDao.saveOrder(new Order("23456789",new Date(),new BigDecimal(1000),0,1));
    }
}