
package com.rmi.reversechecker;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReverseChecker extends Remote {
    boolean isReverse(String str1, String str2) throws RemoteException;
}
