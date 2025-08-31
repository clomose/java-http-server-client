# Mini HTTP Server & Client in Core Java 🚀

This project is a **minimal implementation of an HTTP server and client using only Core Java (Sockets, Input/Output streams, no frameworks like SpringBoot)**.  
It demonstrates how HTTP works under the hood, similar to a very simplified version of **Postman + Server**.

---

## 📂 Project Structure
/src
│ ── Main.java # Basic HTTP server (handles requests)
│ ── HttpResponse.java # Helper to build HTTP responses
│ ── HttpClient.java # Basic HTTP client (sends requests)
│ ── HttpRequest.java # Helper to build HTTP requests


---

## ✨ Features
✅ Simple HTTP Server using `ServerSocket`  
✅ Supports `GET` and `POST` requests  
✅ Custom headers & response builder  
✅ Client implementation using **raw sockets** (no `HttpURLConnection`)  
✅ Request Builder (like a tiny Postman)  

---

## ▶️ How to Run

### 1. Start the Server
```bash
javac Main.java
java Main.java
```
Server will start at:
http://localhost:8080

##2. Run the Client
```bash
javac HttpClient.java
java HttpClient.java
```

##📖 Learning Goals

Understand how HTTP works at the lowest level

Learn how to use Socket, BufferedReader, and PrintWriter

See how requests and responses are just plain text strings

Build a foundation for advanced frameworks (Spring Boot, Netty, etc.)


##🚀 Future Enhancements

Add support for query params & URL routing

Parse and pretty-print JSON responses

Save server logs to file

Build a simple CLI like Postman
