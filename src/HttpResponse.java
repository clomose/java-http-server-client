import java.util.*;

public class HttpResponse {
    private String statusLine;
    private Map<String,String> headers;
    private String body;

    public HttpResponse(){
        headers = new HashMap<>();
        headers.put("Server","MiniJavaServer");
    }

    public HttpResponse setStatus(int code,String message){
        this.statusLine = "HTTP/1.1 " + code + " "+ message;
        return this;
    }

    public HttpResponse setHeaders(String key,String value){
        this.headers.put(key,value);
        return this;
    }

    public HttpResponse setBody(String Body){
        this.body = Body;
        headers.put("Content-Length", String.valueOf(body.getBytes().length));
        return this;
    }

    public String build(){
        StringBuilder response = new StringBuilder();
        response.append(statusLine).append("\r\n");

        for (Map.Entry<String,String> entry : headers.entrySet()){
            response.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }

        response.append("\r\n");

        if(Objects.nonNull(body)){
            response.append(body);
        }

        return response.toString();
    }
}
