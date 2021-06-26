package com.pruebaimatia.springbootdocker;

import com.pruebaimatia.springbootdocker.orderStates.OrderStateEnum;

/**
 *
 * @author Pablo
 * 
 * 
 * Class representing and Order. Its data will be updated with the 
 * tracking data received.
 * 
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
