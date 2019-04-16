package com.company;

import java.util.ArrayList;
import java.util.List;

    public class Game {
        private boolean playing=true;
        public int playerId=0;
        private int nrOfPlayers=0;
        public Board board;
        private final List<Player> players = new ArrayList<>();


        public boolean isPlaying() {
            return playing;
        }

        public void setPlaying(boolean playing) {
            this.playing = playing;
        }
        public void addPlayer(Player player) {
            players.add(player);
            player.setGame(this);
        }

        public Board getBoard() {
            return board;
        }

        public void setBoard(Board board) {
            this.board = board;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public void setWinner(Player player) {
            System.out.println("The winner is " + player.getName());
        }

        public int getNrOfPlayers() {
            return nrOfPlayers;
        }

        public void start() {
            Timmer timmer=new Timmer(this);
            Graph graph = board.getComplete();
            for (Player player : players) {
                nrOfPlayers++;
                player.setId(players.indexOf(player));
                player.setTimmer(timmer);
                new Thread(player).start();
            }

            new Thread(timmer).start();

        }

    }

