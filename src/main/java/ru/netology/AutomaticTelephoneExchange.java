package ru.netology;

import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class AutomaticTelephoneExchange extends Thread {
    private LinkedBlockingQueue callsQueue;

    public AutomaticTelephoneExchange(LinkedBlockingQueue callsQueue) {
        this.callsQueue = callsQueue;
    }

    final static int newCallWaitingTime = 1000;
    final static int quantityOfCallAtOneTime = 40;

    public void run() {
        while (!isInterrupted()) {
            try {
                for (int i = 0; i < quantityOfCallAtOneTime; i++) {
                    callsQueue.add(new Call());
                }
                Thread.sleep(newCallWaitingTime);
            } catch (InterruptedException | NullPointerException exception) {
                exception.printStackTrace();
            }
        }
    }
}
