package com.soap.ssh.spring_rmi.impl;

import com.soap.ssh.spring_rmi.SpringRmiServer;

public class SpringRmiServerImpl implements SpringRmiServer {
    @Override
    public String saySpringRmiHello(String name) {
        return name+" say hello！";
    }
}
