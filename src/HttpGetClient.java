import  java.io.*;
import java.net.*;

public class HttpGetClient {
    public static void main(String[] args) {
        try(Socket socket = new  Socket("localhost",8080)){

            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()));

            out.println("GET / HTTP/1.1");
            out.println("Host: localhost");
            out.println("User-Agent: SimpleHttpClient/1.0");
            out.println("Accept: text/html");
            out.println();

            String line;
            while((line = in.readLine())!=null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
