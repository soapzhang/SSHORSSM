package com.soap.ssh.rmi;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        String uri = "rmi://127.0.0.1/";
        try {
            IService service = (IService) Naming.lookup("rmi://127.0.0.1:1098/server01");
            System.out.println(service.rmiTest("你好!"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
