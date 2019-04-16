package com.company;

public class RandomPlayer extends Player {

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    protected void playIndividual() {
        Edge edge=game.board.extract();
        while(graph.edges.contains(edge))
            edge=game.board.extract();
        graph.add(edge);
        game.board.complete.edges.remove(edge);
        System.out.println( toString(edge));
    }
}