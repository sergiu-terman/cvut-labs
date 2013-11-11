package hw4;

import java.rmi.Naming;

public class Client { 
    
    public static void main(String args[]) throws Exception {
        // get a reference to the remote object
        // assuming the server is running on the localhost
        ConverterInterface o = (ConverterInterface)
            Naming.lookup("//localhost/HelloRMI");
             
        // call the object method
        System.out.println(o.convert("USD", "EUR", 32432.12));
    }
}
