package network;

import com.company.ClientThread;

import java.io.IOException;

public class TimeOut implements Runnable {
    private ClientThread clientThread;
    private boolean ok;
    public TimeOut(ClientThread clientThread)
    {
        this.ok=true;
        this.clientThread=clientThread;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    @Override
    public void run() {
        synchronized (this){
        while (ok){
            try {
                System.out.println("mai ai 10 minute!");
                ok=false;
                this.wait(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
            clientThread.user.logat=false;
            try {
                clientThread.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
    }
}
