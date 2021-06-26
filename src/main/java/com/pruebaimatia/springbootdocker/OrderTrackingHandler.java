package com.pruebaimatia.springbootdocker;

import com.pruebaimatia.springbootdocker.orderStates.OrderStateEnum;
import com.pruebaimatia.springbootdocker.orderStates.OrderStateMachine;

/**
 *
 * @author Pablo
 * 
 * Utility class used for handling the order updates received by the app.
 * Its main functionality is to check if received updates are valid and if so
 * update the orders data.
 */
public class OrderTrackingHandler {
    
    public static void handleOrderTrackingUpdates(OrderTrackings orderTrackings){
        for(OrderTracking orderTracking : orderTrackings.getOrderTrackings()){
            System.out.println("Order id:" + orderTracking.getOrderId());
            System.out.println("Order status:" + orderTracking.getTrackingStatusId());
            System.out.println("Order date:" + orderTracking.getChangeStatusDate());
            
            if(canSaveOrderData(orderTracking)){
                saveOrderData(orderTracking);
            }    
        }
    }
    
    private static Order getOrderFromOrderTracking(OrderTracking orderTracking){
        return new Order(orderTracking.getOrderId(), OrderStateEnum.getStateFromId(orderTracking.getTrackingStatusId()));
    }
    
    private static boolean doesOrderAlreadyExist(int orderId){
        return OrdersDatabase.getData().containsKey(orderId);
    }
    
    private static boolean canSaveOrderData(OrderTracking orderTracking){
        
        boolean canSaveOrderData = false;
        
        if(doesOrderAlreadyExist(orderTracking.getOrderId())){
            Order originalOrderData = OrdersDatabase.getOrderById(orderTracking.getOrderId());
            if(OrderStateMachine.canTransitionTo(
                    originalOrderData.getState(), 
                    OrderStateEnum.getStateFromId(orderTracking.getTrackingStatusId()))
            ){
                canSaveOrderData = true;
            }
        } else {
            canSaveOrderData = true;
        }
        
        return canSaveOrderData;
    }
    
    private static void saveOrderData(OrderTracking orderTracking){
        Order orderData = getOrderFromOrderTracking(orderTracking);
        OrdersDatabase.getData().put(orderData.getOrderId(), orderData);
    }
    
}
