import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner consoleInput = new Scanner(System.in);

        try {
            Socket[] serverSockets = new Socket[3]; // Store connections to three server instances
            ObjectOutputStream[] serverOutputs = new ObjectOutputStream[3];
            ObjectInputStream[] serverInputs = new ObjectInputStream[3];

            for (int i = 0; i < 3; i++) {
                serverSockets[i] = new Socket("localhost", 8080); // Connect to the server instances
                serverOutputs[i] = new ObjectOutputStream(serverSockets[i].getOutputStream());
                serverInputs[i] = new ObjectInputStream(serverSockets[i].getInputStream());
            }

            while (true) {
                System.out.print("Enter a number: ");
                int userInput = Integer.parseInt(consoleInput.nextLine());

                // Choose a random server to send the request
                int randomServerIndex = (int) (Math.random() * 3);

                serverOutputs[randomServerIndex].writeInt(userInput); // Send the input to the selected server
                serverOutputs[randomServerIndex].flush();

                int serverResponse = serverInputs[randomServerIndex].readInt(); // Receive the response
                System.out.println("Server response: " + serverResponse);
            }

        } catch (Exception e) {
            System.out.println("GENERIC ERROR!");
        }
    }
}
