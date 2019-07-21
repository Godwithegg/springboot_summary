package com.danhuang.ticket.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;

@Component
@EnableDubbo
@Service    //将服务发布出去
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "<厉害了，我的蛋>";
    }
}
