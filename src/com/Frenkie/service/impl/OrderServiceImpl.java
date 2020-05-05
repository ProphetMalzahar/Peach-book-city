package com.Frenkie.service.impl;

import com.Frenkie.dao.BookDao;
import com.Frenkie.dao.OrderDao;
import com.Frenkie.dao.OrderItemDao;
import com.Frenkie.dao.impl.BookDaoImpl;
import com.Frenkie.dao.impl.OrderDaoImpl;
import com.Frenkie.dao.impl.OrderItemDaoImpl;
import com.Frenkie.pojo.*;
import com.Frenkie.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    private OrderItemDao orderItemDao=new OrderItemDaoImpl();
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号用用户ID+时间戳，保证唯一性
        String orderId=userId+""+System.currentTimeMillis();
        //创建一个订单对象
        Order order=new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        orderDao.saveOrder(order);
        //把购物车中的所有商品项转化为订单项,保存到数据库中
        for (Map.Entry<Integer,CartItem> entry:cart.getItems().entrySet())
        {
            CartItem cartItem=entry.getValue();
            OrderItem orderItem=new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);
            //将订单保存到数据库后，图书的销量和库存也需要修改
            Book book=bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
}
