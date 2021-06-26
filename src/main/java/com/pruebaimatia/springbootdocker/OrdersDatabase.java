package com.pruebaimatia.springbootdocker;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pablo
 * 
 * Order data should be store in a Database, but due to time constrains and that
 * this is only sample app, Order data will be stored in memory.
 */
public class OrdersDatabase {
    
    private static Map<Integer, Order> orderDB = new HashMap<Integer, Order>();
    
    public static Map<Integer, Order> getData(){
        return orderDB;
    }
    
    public static Order getOrderById(int id){
        return orderDB.get(id);
    }
    
    public static Collection<Order> getAllOrders(){
        return orderDB.values();
    }
    
}
