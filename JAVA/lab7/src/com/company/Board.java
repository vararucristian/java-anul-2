package com.company;

public class Board {
    public Graph complete;
    public Board(int n) {
        complete=new Graph();
        complete.nrOfNodes=n;
        for (int i=1;i<=n;i++)
            for(int j=1;j<i;j++)
                complete.edges.add(new Edge(i,j));
    }
    public synchronized Edge extract() {
        Edge edge = complete.pollFirst();
        return edge;
    }
    public boolean isEmpty() {
        if (complete.edges.isEmpty())
            return true;
        return false;
    }

    public Graph getComplete() {
        return complete;

    }

}