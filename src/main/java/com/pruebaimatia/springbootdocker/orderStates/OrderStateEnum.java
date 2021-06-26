package com.pruebaimatia.springbootdocker.orderStates;

/**
 *
 * @author Pablo
 * 
 * Enumerator representing the different states an Order can be in.
 */
public enum OrderStateEnum {
    RECOGIDO_EN_ALMACEN(1),
    EN_REPARTO(2),
    INCIDENCIA_EN_ENTREGA(3),
    ENTREGADO(4);
    
    
    public final int id;
    
    private OrderStateEnum(int id) {
        this.id = id;
    }
    
    public static OrderStateEnum getStateFromId(final int id)
    {
        for (final OrderStateEnum state : values())
            if (state.id == id)
                return state;
        return null;
    }
}
