package com.company;

public class Timmer implements Runnable {
    private Game game;
    private long begin, end;

    private void start(){
        begin = System.currentTimeMillis();
    }

    private void stop(){
        end = System.currentTimeMillis();
    }
    public Timmer(Game game) {
        this.game = game;
    }

    public void run() {
        synchronized (this){
            start();
            try {
                this.wait(600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stop();
        }
        game.setPlaying(false);
        System.out.println("Jocul a durat:"+(end-begin));
        System.out.println("Jocul s-a incheiat!");
    }

}