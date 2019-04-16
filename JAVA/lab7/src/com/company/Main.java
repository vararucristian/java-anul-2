package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.setBoard(new Board(10));
        Graph graph=new Graph();
        Edge edge=new Edge(1,2);
        game.addPlayer(new RandomPlayer("Player 1"));
        game.addPlayer(new RandomPlayer("Player 2"));
        game.addPlayer(new SmartPlayer("Player 3"));
        game.start();
    }
}
