package com.pruebaimatia.springbootdocker.orderStates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pablo
 * 
 * State Machine for Order States. It contains the valid transitions among 
 * states and provides functionality to check if a transition between two given
 * states is valid.
 * 
 * Doing states static as a way of only creating one of each. 
 * We do not want/it is not needed to instance more than one.
 */
public class OrderStateMachine {
    
    // Key: State, Value: States it can transition to.
    private static Map<OrderStateEnum, List<OrderStateEnum>> machineStates = 
            new HashMap<OrderStateEnum, List<OrderStateEnum>>()
            {{
                // RECOGIDO_EN_ALMACEN
                put(OrderStateEnum.RECOGIDO_EN_ALMACEN, Arrays.asList(
                    OrderStateEnum.RECOGIDO_EN_ALMACEN, 
                    OrderStateEnum.EN_REPARTO, 
                    OrderStateEnum.INCIDENCIA_EN_ENTREGA, 
                    OrderStateEnum.ENTREGADO));
                // EN_REPARTO
                put(OrderStateEnum.EN_REPARTO,
                Arrays.asList(
                    OrderStateEnum.EN_REPARTO, 
                    OrderStateEnum.INCIDENCIA_EN_ENTREGA, 
                    OrderStateEnum.ENTREGADO));
                // INCIDENCIA_EN_ENTREGA
                put(OrderStateEnum.INCIDENCIA_EN_ENTREGA,
                Arrays.asList(
                    OrderStateEnum.EN_REPARTO, 
                    OrderStateEnum.INCIDENCIA_EN_ENTREGA, 
                    OrderStateEnum.ENTREGADO));
                // ENTREGADO
                put(OrderStateEnum.ENTREGADO,
                Arrays.asList(
                    OrderStateEnum.ENTREGADO));
            }};
    
    
    public static boolean canTransitionTo(OrderStateEnum origin, OrderStateEnum target){
        return machineStates.get(origin).contains(target);
    }
    
    /**
     * This code would be better if there was extra logic for each state
     * as we could store more info and even make states to be able to execute
     * certain business logic. With the current use case, simply storing
     * the states and to which ones they can transition to in a data structure 
     * is enough.
     * 
    static class orderState{
        OrderStateEnum state;
        List<OrderStateEnum> transitableStates; //Other states this one can transit to

        public orderState(OrderStateEnum state, List<OrderStateEnum> transitableStates) {
            this.state = state;
            this.transitableStates = transitableStates;
        }
        
    }
    
    private static final orderState recogidoEnAlmacen = new orderState(
            OrderStateEnum.RECOGIDO_EN_ALMACEN,
            Arrays.asList(
                    OrderStateEnum.RECOGIDO_EN_ALMACEN, 
                    OrderStateEnum.EN_REPARTO, 
                    OrderStateEnum.INCIDENCIA_EN_ENTREGA, 
                    OrderStateEnum.ENTREGADO)
    );
    
    private static final orderState enReparto = new orderState(
            OrderStateEnum.EN_REPARTO,
            Arrays.asList(
                    OrderStateEnum.EN_REPARTO, 
                    OrderStateEnum.INCIDENCIA_EN_ENTREGA, 
                    OrderStateEnum.ENTREGADO)
    );
    
    private static final orderState incidenciaEnEntrega = new orderState(
            OrderStateEnum.INCIDENCIA_EN_ENTREGA,
            Arrays.asList(
                    OrderStateEnum.EN_REPARTO, 
                    OrderStateEnum.INCIDENCIA_EN_ENTREGA, 
                    OrderStateEnum.ENTREGADO)
    );
    
    private static final orderState entregado = new orderState(
            OrderStateEnum.ENTREGADO,
            Arrays.asList(OrderStateEnum.ENTREGADO)
    );

    */
    
}
