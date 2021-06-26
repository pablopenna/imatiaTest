package com.pruebaimatia.springbootdocker;

import org.json.simple.JSONArray;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {

        @RequestMapping("/")
        public String home() {
          return "Hello World. Use /order/tracking/";
        }
        
        @RequestMapping(
                method=RequestMethod.GET, 
                produces = "application/json",
                value="/order/tracking/")
        public JSONArray getOrders() {
            JSONArray jsonArray = new JSONArray();
            for(Order order : OrdersDatabase.getAllOrders()){
                System.out.println("------------");
                System.out.println("Order id:" + order.getOrderId());
                System.out.println("Order status:" + order.getState());
                jsonArray.add(order);
            }
            return jsonArray;
        }
        
        @RequestMapping(
                method=RequestMethod.POST, 
                consumes = "application/json",
                value="/order/tracking/")
        public String postOrders(@RequestBody OrderTrackings orderUpdate) {
            OrderTrackingHandler.handleOrderTrackingUpdates(orderUpdate);
            return "OK";
        }
    
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}
