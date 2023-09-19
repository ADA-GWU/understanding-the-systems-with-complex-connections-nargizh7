import java.net.Socket;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {


    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in); // get input from the console
        Socket server; // declare var to hold info about the server (I/O streams)


        try {


            // connect to the server by instantiating socket var
            server = new Socket("localhost", 8080); // connect to the server when it's online to get I/O streams


            // methods for sending and receiving data to and from the server (Java Objects, I/O streams)
            ObjectOutputStream serverOutput = new ObjectOutputStream(server.getOutputStream());
            ObjectInputStream serverInput = new ObjectInputStream(server.getInputStream());


            // prompt a user for some input
            while (true) {
                System.out.print("Enter a number: ");
                int userInput = Integer.parseInt(consoleInput.nextLine()); // retrieve and parse the input as an integer
                serverOutput.writeInt(userInput); // send the integer to the server
                serverOutput.flush(); // flush the output stream to ensure data is sent immediately


                int serverResponse = serverInput.readInt(); // receive server response as an integer
                System.out.println("Server response: " + serverResponse); // print the response
            }


        } catch (Exception e) {
            System.out.println("GENERIC ERROR!"); // if try code causes an error
        }


    }
}
