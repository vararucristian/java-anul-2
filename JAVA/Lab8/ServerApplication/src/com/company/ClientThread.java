package com.company;

import com.sun.org.apache.xml.internal.security.algorithms.MessageDigestAlgorithm;
import network.Message;
import network.Person;
import network.SocialNetwork;
import network.TimeOut;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class ClientThread extends Thread {
        public Socket socket = null;
        private final SocialNetworkServer server;
        private SocialNetwork socialNetwork= new SocialNetwork();
        public Person user;
        private TimeOut timeOut;
    public ClientThread(Socket socket, SocialNetworkServer server,SocialNetwork socialNetwork) {
        this.socket=socket;
        this.server = server;
        this.socialNetwork=socialNetwork;
    }

    // Create the constructor that receives a reference to the server and to the client socket
        public void run() {

                BufferedReader in = null; //client -> server stream
                try{
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true){
                    String request = null;
                try {
                    request = in.readLine();
                } catch (SocketException e) {
                    System.out.println("Clientul s-a deconectat!");
                    user.logat=false;
                    socket.close();
                    break;
                }
                    String response = execute(request);


                PrintWriter out = null; //server -> client stream
                try {
                    out = new PrintWriter(socket.getOutputStream());

                    out.println(response);
                    out.flush();
                } catch (SocketException e) {
                    user.logat=false;
                    socket.close();
                }}
            } catch (Exception e){e.printStackTrace();}
                finally {
                try {
                    socket.close(); //... usse try-catch-finally to handle the exceptions!{
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
        private String execute(String request) {
           try {
           // display the message: "Server received the request ... "
            if(request.split(" ")[0].equals("register")) {
                return register(request.split(" ")[1]);
            }
            if(request.split(" ")[0].equals("login")) {
                return login(request.split(" ")[1]);
            }
            if(request.split(" ")[0].equals("friend")) {
                List<String> names=new ArrayList<String>();
                for(String name:request.split(" "))
                    if(!name.equals("friend"))
                    {names.add(name);
                    }
                return addFriends(names);
            }
            if(request.split(" ")[0].equals("send"))
            {
                String message=request.substring(5,request.length());
                return send(message);
            }
            if(request.equals("read"))
            {
                return read();
            }
            return "Comanda nu a fost corecta!";
           }catch (Exception e){

               return "Comanda nu a fost corecta!";

           }
           }

    private String read() {
        if(user.logat==false)
            return "Nu sunteti logat!";
        synchronized (timeOut){
            timeOut.notify();
            timeOut.setOk(true);
        }
        String messageList="";
        List<Message> oldMessages=new ArrayList<Message>();
        for (Message message:user.messages) {
            messageList = messageList + message.toString();
            oldMessages.add(message);
        }
        for (Message message:oldMessages)
            user.messages.remove(message);
        return messageList;
    }

    private String send(String message) {
        if(user.logat==false)
            return "Nu sunteti logat!";
        synchronized (timeOut){
            timeOut.notify();
            timeOut.setOk(true);
        }
        for (Person person:user.friends)
                person.messages.add(new Message(user.name,message));
        return "Am trimis mesajul!";
    }

    private String register (String name)
        {
            for(Person person:socialNetwork.persons)
            if(person.name.equals(name))
            return "Acest cont exista deja!";
            this.user=new Person(name);
            user.logat=false;
           socialNetwork.persons.add(user);
           return "Persoana "+ name + " a fost adaugata in reteaua sociala.";
        }

        private String login(String name)
        {
            for(Person person:socialNetwork.persons)
                if(name.equals(person.name))
                if(person.logat==true )
                    return "acest cont este deja logat";
                else { user=person;
                    user.logat=true;
                    user.socket=this.socket;
                    timeOut=new TimeOut(this);
                    new Thread(timeOut).start();
                     return "Te-ai autentificat!"        ;}

                return "Contul nu exista!";
        }
        private String addFriends(List<String> names)
        {
            if(user.logat==false)
                return "Nu sunteti logat!";

            synchronized (timeOut){
                timeOut.notify();
                timeOut.setOk(true);
            }
            for(Person person:socialNetwork.persons)
                for(String name:names )
                if(name.equals(person.name))
                {
                    user.friends.add(person);
                }
            StringBuilder friends=new StringBuilder();
            for(Person person:user.friends) {
                friends.append(person.name+" ");}
            return "Am adaugat urmatorele persoane in lista ta de prieteni! "+friends;
        }
    }
