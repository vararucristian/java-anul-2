package network;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Person {
    public String name;
    public List<Person> friends=new ArrayList<Person>();
    public boolean logat=false;
    public Socket socket = null;
    public List<Message> messages;
    public Person(String name) {
        this.name = name;
        messages=new ArrayList<Message>();
    }


}
