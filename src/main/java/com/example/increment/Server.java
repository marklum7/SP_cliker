package com.example.increment;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static int request;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("ждем");

        try (Socket clientSocket = serverSocket.accept();
             InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {

            while ((request = inputStream.read()) != -1) {
                System.out.println(inputStream.read());
                outputStream.write(++request);
                outputStream.flush();
            }
        }
    }
}
