import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java Server <port>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket client = serverSocket.accept();
                ServerHandler handler = new ServerHandler(client);
                handler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ServerHandler extends Thread {
    private static AtomicInteger counter = new AtomicInteger(0);
    private final Socket clientSocket;

    public ServerHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream clientOutput = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream clientInput = new ObjectInputStream(clientSocket.getInputStream());

            while (true) {
                int clientDataInput = clientInput.readInt(); // read data from the client
                int result = clientDataInput * 2;
                
                // Print the result on the server terminal
                System.out.println("Processed request: " + result);
                
                clientOutput.writeInt(result); // send back the result to the client
                clientOutput.flush(); // flush the output stream to ensure data is sent immediately
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



