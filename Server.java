import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {

        System.out.println("server started");
        int port = 11001;

        ServerSocket serverSocket=new ServerSocket(port);

        while(true){

            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("New connection accepted");
            final String name = in.readLine();
            System.out.println("Incoming message: " + name + ", port number "+ clientSocket.getPort());
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            clientSocket.close();

        }

    }
}