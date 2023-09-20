import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            while (true) {
                Socket client = serverSocket.accept();
                ServerHandler handler = new ServerHandler(client);
                handler.start();
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}

class ServerHandler extends Thread {
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
                clientOutput.writeInt(result); // send back the result to the client
                clientOutput.flush(); // flush the output stream to ensure data is sent immediately
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}

