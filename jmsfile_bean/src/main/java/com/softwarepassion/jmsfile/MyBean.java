package com.softwarepassion.jmsfile;

import org.apache.servicemix.MessageExchangeListener;

import javax.annotation.Resource;
import javax.jbi.messaging.DeliveryChannel;
import javax.jbi.messaging.ExchangeStatus;
import javax.jbi.messaging.MessageExchange;
import javax.jbi.messaging.MessagingException;
import javax.jbi.messaging.NormalizedMessage;

public class MyBean implements MessageExchangeListener {

    @Resource
    private DeliveryChannel channel;

    public void onMessageExchange(MessageExchange exchange) throws MessagingException {
        System.out.println("Received exchange: " + exchange);
        
        System.out.println("Received exchange: " + exchange);
        System.out.println("getPattern exchange: " + exchange.getPattern());
        System.out.println("getStatus exchange: " + exchange.getStatus());
        System.out.println("Role exchange: " + exchange.getRole().toString());
        NormalizedMessage in = exchange.getMessage("in");
        System.out.println("normalized message: "+in.getContent().toString());
        exchange.setStatus(ExchangeStatus.DONE);
        channel.send(exchange);
    }

}
