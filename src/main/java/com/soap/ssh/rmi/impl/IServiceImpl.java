package com.soap.ssh.rmi.impl;

import com.soap.ssh.rmi.IService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class IServiceImpl extends UnicastRemoteObject implements IService {
    private String name;

    public IServiceImpl(String name)throws RemoteException{
        this.name=name;
    }
    @Override
    public String rmiTest(String content) {
        return "Server>>"+content;
    }
}
