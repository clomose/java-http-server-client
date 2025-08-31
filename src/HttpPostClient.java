import java.io.*;
import java.net.*;

public class HttpPostClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",8080)) {

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String body = "name=Utkarsh&message=HelloServer";

            out.println("POST / HTTP/1.1");
            out.println("Host : localhost");
            out.println("User-Agent: SimpleHttpClient");
            out.println("Content-Type: application/x-www-form-urlencoded");
            out.println("Content-Length: " + body.length());
            out.println();
            out.println(body);
            out.flush();

            String line;
            while((line = in.readLine())!=null){
                System.out.println(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
