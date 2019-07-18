package com.soap.ssh.spring_rmi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestRmiOfSpring {
    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath:rmi_Server.xml");
    }
}
