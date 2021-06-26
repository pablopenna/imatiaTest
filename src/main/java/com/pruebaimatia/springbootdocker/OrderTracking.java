package com.pruebaimatia.springbootdocker;

import java.util.Date;

/**
 *
 * @author Pablo
 * 
 * Represents the units of data received by the app. 
 * Each one of the instances of this class represents
 * an update on the data of single Order.
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
