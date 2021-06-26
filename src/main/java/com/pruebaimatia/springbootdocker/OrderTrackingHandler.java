package com.pruebaimatia.springbootdocker;

import com.pruebaimatia.springbootdocker.orderStates.OrderStateEnum;
import com.pruebaimatia.springbootdocker.orderStates.OrderStateMachine;

/**
 *
 * @author Pablo
 */
public class OrderTrackingHandler {
    
    public static void handleOrderTrackingUpdates(OrderTrackings orderTrackings){
        for(OrderTracking orderTracking : orderTrackings.getOrderTrackings()){
            System.out.println("Order id:" + orderTracking.getOrderId());
            System.out.println("Order status:" + orderTracking.getTrackingStatusId());
            System.out.println("Order date:" + orderTracking.getChangeStatusDate());
            
            Order orderData = getOrderFromOrderTracking(orderTracking);
            
            if(!doesOrderAlreadyExist(orderData.getOrderId())){
                saveOrderData(orderData);
            } else {
                Order originalOrderData = OrdersDatabase.getOrderById(orderData.getOrderId());
                if(OrderStateMachine.canTransitionTo(originalOrderData.getState(), orderData.getState())){
                    saveOrderData(orderData);
                } 
            }
                
        }
    }
    
    private static Order getOrderFromOrderTracking(OrderTracking orderTracking){
        return new Order(orderTracking.getOrderId(), OrderStateEnum.getStateFromId(orderTracking.getTrackingStatusId()));
    }
    
    private static boolean doesOrderAlreadyExist(int orderId){
        return OrdersDatabase.getData().containsKey(orderId);
    }
    
    private static void saveOrderData(Order orderData){
        OrdersDatabase.getData().put(orderData.getOrderId(), orderData);
    }
    
}
