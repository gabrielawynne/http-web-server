# Simple HTTP Web Server

A basic HTTP server written in Java from scratch — no frameworks, just `ServerSocket` and raw stream handling. Listens on port 8080, parses incoming GET requests, and serves files back to the client.

Good for understanding how HTTP actually works under the hood before you let a library handle it for you.

## Build & Run

You need Java installed (any version should work).

```bash
cd SimpleWebServer
javac SimpleWebServer.java
java SimpleWebServer
```

The server starts on `http://localhost:8080`.

## How it works

On each connection:
1. Accepts the TCP connection via `ServerSocket`
2. Reads the HTTP request line (e.g. `GET /index.html HTTP/1.1`)
3. Parses the requested path
4. Reads the file from disk and writes it back with a basic HTTP response header
5. Closes the connection

Handles one request at a time. Only GET is supported — anything else returns an appropriate error response.
