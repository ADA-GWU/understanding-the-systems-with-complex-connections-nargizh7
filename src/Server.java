import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.*;

public class Server {
    public static void main(String[] args) {
    	
    	// check if the correct number of cli arguments is provided
        if (args.length != 1) {
            System.err.println("You have to indicate 1 port: java Server <port>");
            System.exit(1);
        }

        // parse the server port number 
        int port = Integer.parseInt(args[0]);

        try {
        	
            // listen for client connections
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
            	
                // accept a client connection and communicate with the client
                Socket client = serverSocket.accept();
                
                // new instance of ServerHandler to handle the client's request
                ServerHandler handler = new ServerHandler(client);
                
                // new thread to handle the client's request concurrently
                handler.start();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ServerHandler extends Thread {
	
    // keep track of the number of client threads
    private static AtomicInteger counter = new AtomicInteger(0);
    private final Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
    	
        // initialize the client socket
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
        	
            // read data from the client
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
            	
                // read a line of data from the client
                String clientDataInput = clientInput.readLine();
                
                // check if the client has disconnected
                if (clientDataInput == null) {
                    break;
                }
                
                // parse the received data as an integer
                int userInput = Integer.parseInt(clientDataInput);
                
                // multiply by 2 
                int result = userInput * 2;

                // print the result on the server's terminal
                System.out.println("Processed request on port " + clientSocket.getLocalPort() + ": " + result);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
