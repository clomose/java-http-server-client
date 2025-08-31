import java.util.*;

public class HttpRequest {
    private Map<String,String> headers;
    private String body;
    private String method;
    private String path;

    public HttpRequest(String method,String path){
        headers = new HashMap<>();
        this.method = method;
        this.path = path;
    }

    public HttpRequest addHeader(String key,String value){
        this.headers.put(key,value);
        return this;
    }

    public HttpRequest setBody(String body){
        this.body = body;
        return this;
    }

    public String build(String host){
        StringBuilder request = new StringBuilder();

        request.append(method).append(" ").append(path).append(" HTTP/1.1\r\n");
        request.append("Host: ").append(host).append("\r\n");

        for(Map.Entry<String,String> entry : headers.entrySet()){
            request.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }

        if(body!=null && !body.isEmpty()){
            request.append("Content-Length: ").append(body.length()).append("\r\n");
        }

        request.append("\r\n");

        if(body!=null){
            request.append(body);
        }

        return request.toString();
    }
}
