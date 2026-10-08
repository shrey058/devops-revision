package com.devops;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class App {

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
                new InetSocketAddress(8081), 0
        );

        server.createContext("/", exchange -> {

            String response = "Hello DevOps from Kubernetes!";

            exchange.sendResponseHeaders(
                    200,
                    response.getBytes().length
            );

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();

        System.out.println("Server started on port 8081");
    }
}
