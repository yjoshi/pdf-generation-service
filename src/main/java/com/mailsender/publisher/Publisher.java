package com.mailsender.publisher;

import com.mailsender.bean.UserData;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
	
   @Autowired
   private AmqpTemplate myrabbitTemplate;
   
   @Value("${pdf.rabbitmq.exchange}")
   private String exchange;
   
   @Value("${pdf.rabbitmq.routingkey}")
   private String routingKey;
   
   public void produceMsg(UserData data){
	   myrabbitTemplate.convertAndSend(exchange, routingKey, data);
      System.out.println("Message Sent: " + data.toString());
   }
}

