package com.soap.ssh.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IService extends Remote {

    String rmiTest(String content) throws RemoteException;
}
