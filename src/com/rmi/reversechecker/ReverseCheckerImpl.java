
package com.rmi.reversechecker;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReverseCheckerImpl extends UnicastRemoteObject implements ReverseChecker {

    protected ReverseCheckerImpl() throws RemoteException {
        super();
    }

    // Method to check if str1 is the reverse of str2
    @Override
    public boolean isReverse(String str1, String str2) throws RemoteException {
        // Reverse str2 and compare with str1
        StringBuilder reversedStr2 = new StringBuilder(str2).reverse();
        return str1.equals(reversedStr2.toString());
    }

    // Main method to start the server and bind it to the registry
    public static void main(String[] args) {
        try {
            // Create and export the remote object
            ReverseCheckerImpl checker = new ReverseCheckerImpl();

            // Start the RMI registry on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the remote object with the name "ReverseChecker"
            registry.rebind("ReverseChecker", checker);

            System.out.println("Server is ready.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
