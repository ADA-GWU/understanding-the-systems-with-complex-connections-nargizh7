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

        // parse the server port number from cli arguments
        int port = Integer.parseInt(args[0]);

        try {
        	
            // listen for incoming client connections on the specified port
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
            	
                // wait and accept client connections to communicate 
                Socket client = serverSocket.accept();
                
                // create a new instance of ServerHandler to handle the client's request
                ServerHandler handler = new ServerHandler(client);
                
                // start a new thread to handle multiple client connections concurrently
                handler.start();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// inner class used to handle client's request
class ServerHandler extends Thread {
	
    // keep track of the number of client threads that have been created
    private static AtomicInteger counter = new AtomicInteger(0);
    
    // the socket through which the server communicates with a specific client
    private final Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
    	
        // initialize the client socket instance variable with the provided Socket
        this.clientSocket = clientSocket;
    }

    @Override
    
    // invoke the method when the thread is started 
    public void run() {
        try {
        	
            // read data sent by the client and wrap the input stream to allow char-based reading
            BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            while (true) {
            	
                // read a line of data from sent by the client
                String clientDataInput = clientInput.readLine();
                
                // check if the client has disconnected or there is no more data to read
                if (clientDataInput == null) {
                    break;
                }
                
                // parse the received data as an integer - allows the server to work with the data
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
