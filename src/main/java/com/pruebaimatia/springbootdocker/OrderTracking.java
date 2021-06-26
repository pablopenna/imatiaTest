/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaimatia.springbootdocker;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Pablo
 */
public class OrderTracking {
    private final int orderId;
    private final int trackingStatusId;
    private final Date changeStatusDate;

    public OrderTracking(int orderId, int trackingStatusId, Date changeStatusDate) {
        this.orderId = orderId;
        this.trackingStatusId = trackingStatusId;
        this.changeStatusDate = changeStatusDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getTrackingStatusId() {
        return trackingStatusId;
    }

    public Date getChangeStatusDate() {
        return changeStatusDate;
    }
    
    
}
