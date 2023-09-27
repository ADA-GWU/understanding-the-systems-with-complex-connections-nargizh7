# understanding-the-systems-with-complex-connections-nargizh7
understanding-the-systems-with-complex-connections-nargizh7 created by GitHub Classroom


This README provides detailed instructions on how to install, compile, and run the client-server application. 
The application consists of a client (`Client.java`) and three server instances (`Server.java`) that communicate over a local network. 

Installation:
1. You have to set up a Java Development Environment.
2. Clone the application repository to your local machine:
   git clone https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-nargizh7.git
3. Change your working directory to the project directory:
   cd understanding-the-systems-with-complex-connections-nargizh7
4. Enter the "src" directory where the code files are located: cd src
   
Compilation:
1. Compile the Client.java file: javac Client.java
2. Compile the Server.java file: javac Server.java

Running the Client-Server Application:
1. In three separate terminal windows, start the server instances on different ports. 
   Example:
   In the 1st terminal window, run the server on port 12345:  java Server 12345
   In the 2nd terminal window, run the server on port 23456:  java Server 23456
   In the 3rd terminal window, run the server on port 34567:  java Server 34567
2. In a 4th terminal window, run the client, providing the ports of the three servers as command-line arguments.
   Example:
   In the fourth terminal window, run the client with the following command: java Client 12345 23456 34567

Usage:
Once the client is running, it will prompt you to enter a number. 
Enter an integer value, and the client will determine which server to send the request to.
The client will output the port of the server that is processing the request.
Navigate to the specified server terminal and check the result that the server outputted.
You can continue to enter numbers, and the client will distribute requests to the servers using round-robin scheduling.


Notes to consider:
1. Ensure that you have Java installed and properly configured on your system.
2. The provided instructions assume you are running the client and servers on a single machine ("localhost"). 
   If you intend to run them on different machines, replace "localhost" with the appropriate server addresses in the `Client.java` file.


