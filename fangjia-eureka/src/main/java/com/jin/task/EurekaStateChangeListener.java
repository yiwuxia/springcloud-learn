package com.jin.task;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaStateChangeListener {

    @EventListener
    public void listene(EurekaInstanceCanceledEvent event){
        System.out.println("下线啦=====");
    }

}
