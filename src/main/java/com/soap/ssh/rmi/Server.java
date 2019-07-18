package com.soap.ssh.rmi;

import com.soap.ssh.rmi.impl.IServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1098);
            Naming.bind("rmi://127.0.0.1:1098/server01",new IServiceImpl("server01") );
        }catch (Exception e){

        }
        System.out.println("服务器向命名表注册了1个远程服务对象！");
    }

}
