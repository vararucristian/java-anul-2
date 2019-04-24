package com.company;

import network.SocialNetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocialNetworkServer {
        private static final int PORT = 8100;
        private ServerSocket serverSocket;
        private boolean running = false;
        private SocialNetwork socialNetwork= new SocialNetwork();
        public static void main(String[] args)  {
            SocialNetworkServer server = new SocialNetworkServer();
            server.init();
            server.waitForClients(); //... handle the exceptions!
        }

        private void waitForClients() {
            try {
            while(true){
                System.out.println("Waiting for a client!");

                    Socket socket=serverSocket.accept();
                    new ClientThread(socket, this,socialNetwork).start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void init() {
            try {
                serverSocket=new ServerSocket(8100);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    // Implement the init() method: create the serverSocket and set running to true
    // Implement the waitForClients() method: while running is true, create a new socket for every incoming client and start a ClientThread to execute its request.

        public void stop() throws IOException {
            this.running = false;
            serverSocket.close();
        }
    }
