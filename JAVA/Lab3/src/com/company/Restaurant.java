package com.company;

public class Restaurant extends Node implements Classifiable {
    int rank;

    public Restaurant(String name) {
        super(name);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
