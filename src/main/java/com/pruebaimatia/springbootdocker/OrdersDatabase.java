/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaimatia.springbootdocker;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pablo
 * 
 * Order data should be store in a Database, but due to time constrains and that
 * this is only sample app, I will store Order data in memory.
 */
public class OrdersDatabase {
    
    private static Map<Integer, Order> orderDB = new HashMap<Integer, Order>();
    
    public static Map<Integer, Order> getData(){
        return orderDB;
    }
    
    public static Order getOrderById(int id){
        return orderDB.get(id);
    }
    
}
