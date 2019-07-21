package com.danhuang.task;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot04TaskApplicationTests {

    @Autowired
    JavaMailSender mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件信息
        message.setSubject("通知-今晚开会");
        message.setText("今晚7：30开会");

        message.setTo("1034268001@qq.com");
        message.setFrom("675175647@qq.com");
        mailSender.send(message);
    }

    @Test
    public void test02() throws MessagingException {
        //1.创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //邮件信息
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今晚7：30开会</b>",true);

        //上传文件
        helper.addAttachment("1.jpg",new File("E:\\github\\springboot_summary\\springboot-advanced\\spring-boot-04-task\\src\\main\\resources\\static\\img\\lufei.jpg"));
        helper.addAttachment("2.jpg",new File("E:\\github\\springboot_summary\\springboot-advanced\\spring-boot-04-task\\src\\main\\resources\\static\\img\\suolong.jpg"));


        helper.setTo("1034268001@qq.com");
        helper.setFrom("675175647@qq.com");
        mailSender.send(mimeMessage);
    }

}
