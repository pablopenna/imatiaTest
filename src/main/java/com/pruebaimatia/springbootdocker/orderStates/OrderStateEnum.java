/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pruebaimatia.springbootdocker.orderStates;

/**
 *
 * @author Pablo
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
