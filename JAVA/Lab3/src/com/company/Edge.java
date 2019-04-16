package com.company;

public class Edge {
     Node start;
     Node finish;
     int cost;

    public Edge(Node start, Node finish, int cost) {
        this.start = start;
        this.finish = finish;
        this.cost = cost;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getFinish() {
        return finish;
    }

    public void setFinish(Node finish) {
        this.finish = finish;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.start.name+"-"+this.finish.name+"\n";
    }
}
