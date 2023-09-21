import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java Client <port1> <port2> <port3>");
            System.exit(1);
        }

        Scanner consoleInput = new Scanner(System.in);

        try {
            Socket[] serverSockets = new Socket[3]; // store connections to 3 server instances
            ObjectOutputStream[] serverOutputs = new ObjectOutputStream[3];
            ObjectInputStream[] serverInputs = new ObjectInputStream[3];

            // Get server ports from command line arguments
            int[] serverPorts = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])};

            for (int i = 0; i < 3; i++) {
                serverSockets[i] = new Socket("localhost", serverPorts[i]); // connect to the server instances
                serverOutputs[i] = new ObjectOutputStream(serverSockets[i].getOutputStream());
                serverInputs[i] = new ObjectInputStream(serverSockets[i].getInputStream());
            }

            while (true) {
                System.out.print("Enter a number: ");
                int userInput = Integer.parseInt(consoleInput.nextLine());

                // Round-robin selection of servers
                int selectedServer = userInput % 3;

                serverOutputs[selectedServer].writeInt(userInput); // send the input to the selected server
                serverOutputs[selectedServer].flush();

                int serverResponse = serverInputs[selectedServer].readInt(); // receive the response
                System.out.println("Server response: " + serverResponse);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



