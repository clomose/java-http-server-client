import java.io.*;
import java.net.*;

public class HttpClient {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 8080;

        Socket socket = new Socket(host,port);

        HttpRequest request = new HttpRequest("POST","/create");
        request.addHeader("Content-Type","application/json");
        request.setBody("{\"name\": \"Utkarsh\", \"role\": \"developer\"}");

        String rawRequest = request.build(host);

        PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
        out.println(rawRequest);
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder rawResponse = new StringBuilder();
        String line;
        while ((line = in.readLine())!=null){
            rawResponse.append(line).append("\r\n");
            if(line.isEmpty()) break;
        }

        System.out.println("Raw Response:\n" + rawResponse.toString());

        socket.close();

    }
}
