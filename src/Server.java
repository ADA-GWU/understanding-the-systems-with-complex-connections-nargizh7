import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Server {


    public static void main(String[] args) {
        try {
            // making a way for a client to connect to the server
            ServerSocket serverSocket = new ServerSocket(8080); // hosting server on port 8080
            /* waits for the client to connect
            when it connects -> returns Socket object representing the client 
            the line is linked to server = new Socket("localhost", 8080); - when this one runs*/
            Socket client = serverSocket.accept(); // this one returns a client Socket


            // setup I/O streams
            ObjectOutputStream clientOutput = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream clientInput = new ObjectInputStream(client.getInputStream());


            while (true) {
                int clientDataInput = clientInput.readInt(); // reading data as an integer
                int result = clientDataInput * 2; // multiply the input by 2
                clientOutput.writeInt(result); // send back the result to the client
                clientOutput.flush(); // flush the output stream to ensure data is sent immediately
            }
        } catch (Exception e) {
            System.out.println("ERROR!");
        }
    }
}
