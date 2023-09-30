import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
    	
        // check if the correct number of cli arguments is provided
        if (args.length != 3) {
            System.err.println("You have to indicate 3 ports: java Client <port1> <port2> <port3>");
            System.exit(1);
        }

        // scanner to read input from the console
        Scanner consoleInput = new Scanner(System.in);

        try {
        	
            // Socket objects used to establish connections to 3 different servers
            Socket[] serverSockets = new Socket[3];
            
            // PrintWriter objects used to send data to these 3 servers
            PrintWriter[] serverOutputs = new PrintWriter[3];

            // store port numbers for 3 servers, they are parsed from cli arguments
            int[] serverPorts = { Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]) };

            while (true) {
            	
                System.out.print("Enter a number: ");
                
                // read  input stores the value entered by the user from the console. This input will be used to determine which server should process the request.
                int userInput = Integer.parseInt(consoleInput.nextLine());

                // determine which server will process the request and ensure that the selected server will be one of the 3 servers, depending on the user's input
                int selectedServer = userInput % 3;
                System.out.println("Request is processed by the server on port: " + serverPorts[selectedServer]);

                // connect to the selected server
                serverSockets[selectedServer] = new Socket("localhost", serverPorts[selectedServer]);
                
                // send data to the chosen server
                serverOutputs[selectedServer] = new PrintWriter(new OutputStreamWriter(serverSockets[selectedServer].getOutputStream()));

                // send the user input to the selected server - write the data to the output stream associated with the selected server's socket
                serverOutputs[selectedServer].println(userInput);
                
                // ensure that the data is immediately sent over the network rather than waiting in a buffer
                serverOutputs[selectedServer].flush();

                // pause for 1 second to allow the server to process the request before looping again
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
