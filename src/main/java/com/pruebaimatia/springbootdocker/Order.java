/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaimatia.springbootdocker;

import com.pruebaimatia.springbootdocker.orderStates.OrderStateEnum;

/**
 *
 * @author Pablo
 */
public class Order {
    private int orderId;
    private OrderStateEnum state;
    
    public Order(int id, OrderStateEnum state) {
        this.orderId = id;
        this.state = state;
    }
    
    public int getOrderId(){
        return this.orderId;
    }
    
    public OrderStateEnum getState(){
        return this.state;
    }
    
}
