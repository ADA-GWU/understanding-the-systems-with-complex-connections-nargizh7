import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        // check if the correct number of cli arguments is provided
        if (args.length != 3) {
            System.err.println("Usage: java Client <port1> <port2> <port3>");
            System.exit(1);
        }

        // scanner to read input from the console
        Scanner consoleInput = new Scanner(System.in);

        try {
            // arrays to hold sockets and output streams for three servers
            Socket[] serverSockets = new Socket[3];
            PrintWriter[] serverOutputs = new PrintWriter[3];

            // parse the server port numbers from cli arguments
            int[] serverPorts = { Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]) };

            while (true) {
                System.out.print("Enter a number: ");
                // read integer input 
                int userInput = Integer.parseInt(consoleInput.nextLine());

                // determine which server will process the request 
                int selectedServer = userInput % 3;
                System.out.println("Request will be processed by server on port: " + serverPorts[selectedServer]);

                // socket to connect to the selected server
                serverSockets[selectedServer] = new Socket("localhost", serverPorts[selectedServer]);
                // send data to the server
                serverOutputs[selectedServer] = new PrintWriter(new OutputStreamWriter(serverSockets[selectedServer].getOutputStream()));

                // send the user input to the selected server
                serverOutputs[selectedServer].println(userInput);
                serverOutputs[selectedServer].flush();

                // wait to allow the server to process the request
                Thread.sleep(1000);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
