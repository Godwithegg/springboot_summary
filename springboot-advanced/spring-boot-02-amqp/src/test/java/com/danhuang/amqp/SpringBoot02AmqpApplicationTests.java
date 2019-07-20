package com.danhuang.amqp;

import com.danhuang.amqp.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02AmqpApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    public void createExchange(){
//        amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
//        System.out.println("创建完成");
//        amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
//        System.out.println("创建成功");
        //创建绑定规则
        amqpAdmin.declareBinding(new Binding("amqpadmin.queue",
                Binding.DestinationType.QUEUE,"amqpadmin.exchange",
                "amqp.haha",null));
//        amqpAdmin.deleteExchange();
    }


    /**
     * 1.单播（点对点）
     */

    @Test
    public void contextLoads() {
        //message需要自己构造一个；定义消息体内容和消息头
        //rabbitTemplate.send(exchange,routeKey,message);
//        object默认被当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
//        rabbitTemplate.convertAndSend(exchange,routeKey,Object);
        Map<String,Object> map = new HashMap<>();
        map.put("msg","这是第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","danhuang.news",new Book("蛋黄内经","蛋黄"));
    }

    //接收数据，如何将数据自动转为json发送出去
    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("danhuang.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    //广播
    @Test
    public void sendMsg(){
        rabbitTemplate.convertAndSend("exchange.fanout","",new Book("小蛋黄","蛋"));
    }


}
