package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocialNetworkClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    private static Socket socket;
    public static void main(String[] args) throws IOException {
        socket = new Socket(SERVER_ADDRESS, PORT);
        SocialNetworkClient client = new SocialNetworkClient();

        while (true) {
            String request = client.readFromKeyboard();
            if (request.equalsIgnoreCase("exit")) {
                break;
            } else {
                client.sendRequestToServer(request);
            }

        }
    }

    private void sendRequestToServer(String request)  throws IOException{
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader ( new InputStreamReader(socket.getInputStream()));
            out.println(request);
            String response=in.readLine();
            if(response.contains("\"n\""))
                for(String text:response.split("\"n\""))
                    System.out.println(text);
            else
                System.out.println(response);
    }
    //Implement the sendRequestToServer method

    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}