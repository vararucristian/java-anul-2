package com.company;

public abstract class Player implements Runnable {

    protected static final long THINKING_TIME =300;
    protected String name;
    protected Game game;
    protected Graph graph;
    protected int id;
    protected Timmer timmer;

    public Timmer getTimmer() {
        return timmer;
    }

    public void setTimmer(Timmer timmer) {
        this.timmer = timmer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player(String name) {
        this.name = name;
    }


    protected boolean play() throws InterruptedException {
        synchronized (game){

            if(game.isPlaying()==false)
            {   game.notifyAll();
                return false;
            }
            while(id!=game.playerId) {
                game.wait();
            }
            if(game.isPlaying()==false)
            {   game.notifyAll();
                return false;
            }
            game.playerId=(game.playerId+1);
            if(game.playerId==3)
                game.playerId=0;
            if (game.board.isEmpty()) {
                game.notifyAll();
                synchronized (timmer){
                    timmer.notify();}
                return false; }
            Thread.sleep(THINKING_TIME);
            playIndividual();
            if (graph.isSpanningTree()) {
                game.setWinner(this);
                synchronized (timmer){
                    timmer.notify();}
                game.setPlaying(false);
                return false;
            }
            game.notifyAll();
            return true;
        }
    }

    protected abstract void playIndividual();
    public void setGame(Game game) {
    this.game=game;
    }

    public static long getThinkingTime() {
        return THINKING_TIME;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    public void addEdge(Edge e){
        graph.add(e);
    }

    @Override
    public void run() {
        graph=new Graph();
        this.graph.nrOfNodes=game.getBoard().getComplete().nrOfNodes;
        this.graph.add(game.getBoard().getComplete().pollFirst());
        game.board.complete.edges.remove(graph.edges.get(0));
        while (true) {

            try {
                if(play()==false)
                    break;
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
        }

    }

// implement the run() method, that will repeatedly extract edges
    // implement the toString() method

    public String toString(Edge edge) {
        return "Player-ul: "+name+" a ales muchia "+edge.node1+"-"+edge.node2;
    }
}