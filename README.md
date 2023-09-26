# understanding-the-systems-with-complex-connections-nargizh7
understanding-the-systems-with-complex-connections-nargizh7 created by GitHub Classroom

This README provides detailed instructions on how to install, compile, and run the client-server application. 
The application consists of a client (`Client.java`) and three server instances (`Server.java`) that communicate over a local network. 
I assume you have the code files and Java development environment set up.

Installation:
1. Clone the application repository to your local machine using the following command:
   git clone https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-nargizh7.git
2. Change your working directory to the project directory:
   cd understanding-the-systems-with-complex-connections-nargizh7
3. Enter the "src" directory where the code files are located: cd src
   
Compile the Java source files for both the Client and Server:
1. Open a terminal window and navigate to the "src" directory within the project.
   Compile the Client.java file using the javac command: javac Client.java
2. Open another terminal window and navigate to the "src" directory within the project.
   Compile the Server.java file using the javac command: javac Server.java

Running the Application:
1. Start the Server Instances
In three separate terminal windows, start the server instances on different ports. 
The servers will listen for incoming client connections.
Example:
In the first terminal window, run the server on port 12345:  java Server 12345
In the second terminal window, run the server on port 23456: java Server 23456
In the third terminal window, run the server on port 34567:  java Server 34567
2. Run the Client
In a fourth terminal window, run the client, providing the ports of the three servers as command-line arguments.
Example:
In the fourth terminal window, run the client with the following command:  java Client 12345 23456 34567
     ```

Usage:
Once the client is running, it will prompt you to enter a number. Enter an integer value, and the client will determine which server to send the request to based on the input.
The selected server will process the request by multiplying the input by 2 and print the result on its terminal.
You can continue to enter numbers, and the client will distribute requests to the servers in a round-robin fashion.

Notes to consider:
1. Ensure that you have Java installed and properly configured on your system.
2. The provided instructions assume you are running the client and servers on a single machine ("localhost"). If you intend to run them on different machines, replace "localhost" with the appropriate server addresses in the `Client.java` file.
3. This is a basic example, and in a real-world scenario, you would need to handle exceptions, implement graceful shutdown procedures, and possibly add more robust error handling.

