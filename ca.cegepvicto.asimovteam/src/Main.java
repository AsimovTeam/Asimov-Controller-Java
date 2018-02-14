import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

public class Main {

    private static Socket socket;


    public static void main( String[] args ) {
        //Définition des paramêtres de connexion
        String host = "localhost";
        int port = 44000;

        //Éssai de connexion au serveur
        try {
            socket = new Socket(host, port);

            PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);

            outputStream.println("{\"message\":\"hello world!\"}");
            outputStream.println("{\"message\":\"close\"}");

        } catch (Exception e) {

            if(e.getMessage().equals("Connection refused: connect")) {
                System.out.println("Server is offline/unreachable");
                System.exit(-1);
            }

            e.printStackTrace();
            System.exit(-1);
        }
    }
}
