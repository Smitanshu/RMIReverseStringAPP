
package com.rmi.reversechecker;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReverseClient {

    public static void main(String[] args) {
        try {
            // Connect to the RMI registry on the local machine
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup the remote object by name
            ReverseChecker checker = (ReverseChecker) registry.lookup("ReverseChecker");

            // Define two strings to check
            String str1 = "tset";
            String str2 = "test";

            // Call the remote method
            boolean isReverse = checker.isReverse(str1, str2);

            // Print the result based on the return value
            if (isReverse) {
                System.out.println("String 1 is the reverse of String 2.");
            } else {
                System.out.println("String 1 is NOT the reverse of String 2.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
