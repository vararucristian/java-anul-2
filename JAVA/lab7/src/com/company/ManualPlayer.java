package com.company;
import java.io.DataInputStream;
import java.io.IOException;

public class ManualPlayer extends Player {


    public ManualPlayer(String name) {
        super(name);
    }

    @Override
    protected void playIndividual() {
        DataInputStream in = new DataInputStream(System.in);
        for (Edge edge:game.board.complete.edges)
                System.out.println(game.board.complete.edges.indexOf(edge)+")"+ edge.node1+"-"+edge.node2);
        System.out.print("Alege o muchie:");
        int index= 0;
        try {
            index = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Edge edge=game.board.complete.edges.get(index);
            graph.add(edge);
            game.board.complete.edges.remove(edge);
            System.out.println( toString(edge));

    }
}