package com.danhuang.starter;

import org.springframework.beans.factory.annotation.Autowired;

public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHelloDanhuang(String name){

        return helloProperties.getPrefix() + "-" + name + "-" + helloProperties.getSuffix();
    }
}
