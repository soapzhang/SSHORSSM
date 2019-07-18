package com.soap.ssh.spring_rmi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRmiServerClient {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("rmi_Client.xml");
        SpringRmiServer rmiServer = context.getBean("rmiServer", SpringRmiServer.class);
        System.out.println(rmiServer.saySpringRmiHello("soap"));
    }
}
