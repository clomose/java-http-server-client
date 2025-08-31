import java.io.*;
import java.net.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        //Create the server socket
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server Started on http://localhost:8080");

        while(true){
            //accept client connection
            Socket clientSocket = serverSocket.accept();
            handleClient(clientSocket);
        }
    }

    private static void handleClient(Socket clientSocket){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            OutputStream out = clientSocket.getOutputStream()) {

            HttpResponse response = new HttpResponse();

            //In first line http methods and path
            String requestLine = in.readLine();
            if(requestLine==null || requestLine.isEmpty()) return;
            System.out.println("Request: "+requestLine);

            //paring first line
            String[] parts = requestLine.split(" ");
            String method = parts[0];
            String path = parts[1];
            String protocol = parts[2];

            //Parse Headers
            Map<String,String> headers = new HashMap<>();
            String line;
            while(!(line=in.readLine()).isEmpty()){
                String[] headerPart = line.split(": ",2);
                headers.put(headerPart[0],headerPart[1]);
            }

            //Parse body if present
            String body = null;
            if (headers.containsKey("Content-Length")){
                int length = Integer.parseInt(headers.get("Content-Length"));
                char []bodyChars = new char[length];
                in.read(bodyChars);
                body = new String(bodyChars);
            }

            System.out.println("Body : "+body);

            String responseBody = "You sent: " + method + " " + path + "\nBody: " + body;
            response.setStatus(200,"Ok")
                    .setHeaders("Content-Type","text/plain")
                    .setBody(responseBody);

            //send response;
            out.write(response.build().getBytes());
            out.flush();

            clientSocket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}