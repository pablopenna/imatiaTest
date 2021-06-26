package com.pruebaimatia.springbootdocker;

import java.util.List;

/**
 *
 * @author Pablo
 * 
 * Wrapper for the OrderTracking class. This class is used so Spring Boot can
 * properly parse and cast the body of the requests received.
 * 
 */
public class OrderTrackings {
    
    private List<OrderTracking> orderTrackings;
    
    public List<OrderTracking> getOrderTrackings() {
        return this.orderTrackings;
    }
}
