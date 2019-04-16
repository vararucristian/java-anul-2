package com.company;

public class Hotel extends Node implements Classifiable{
    int rank;

    public Hotel(String name) {
        super(name);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
