# understanding-the-systems-with-complex-connections-nargizh7
understanding-the-systems-with-complex-connections-nargizh7 created by GitHub Classroom


This README provides detailed instructions on how to install, compile, and run this client-server application. 
The application consists of a client (`Client.java`) and three server instances (`Server.java`) that communicate over a local network. 

Notes to consider before starting:
1. Ensure that you have Java installed, properly configured and updated; a Java Development Environment must be set up.
2. The provided instructions assume you are running the client and servers on a single machine ("localhost"). 
(If you intend to run them on different machines, replace "localhost" with the appropriate server addresses in the `Client.java` file)

Installation:
1. Clone the application repository to your local machine:
   git clone https://github.com/ADA-GWU/understanding-the-systems-with-complex-connections-nargizh7.git
2. Change your working directory to the project directory:
   cd understanding-the-systems-with-complex-connections-nargizh7
3. Enter the "src" directory where the code files are located: cd src
   
Compilation:
Open 4 terminal instances and compile Client.java and Server.java files in each terminal window using these 2 commands:
javac Client.java
javac Server.java

Running the Client-Server Application:
1. In 3 terminal windows, start the server instances on different ports. You are free to choose port number yourself.
   Options provided below are suggested.
   Example:
   In the 1st terminal window, run the server on port 12345 using:  java Server 12345
   In the 2nd terminal window, run the server on port 23456 using:  java Server 23456
   In the 3rd terminal window, run the server on port 34567 using:  java Server 34567
3. In a 4th terminal window, run the client by providing the ports of the three of your servers as command-line arguments.
   Example:
   In the 4th terminal window, run the client using: java Client 12345 23456 34567

Usage:
Once the client is running, it will prompt you to enter a number. 
Enter an integer value, and the client will determine which server to send the request to.
The client will output the port of the server that is processing the request.
Navigate to the specified server terminal and check the result that the server outputted.
You can continue to enter numbers, and the client will distribute requests to the servers using round-robin scheduling.





