package ru.netology;

import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

public class Operator extends Thread{
    private LinkedBlockingQueue callsQueue;
    private String name;

    //aht - average handing time
    final static int aht = 4000;

    public Operator(LinkedBlockingQueue callsQueue, String name) {
        this.callsQueue = callsQueue;
        this.name = name;
    }

    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(aht);
                callsQueue.remove();
                System.out.println(name + " принял новый звонок.");
            }
        }   catch (InterruptedException | NoSuchElementException exception) {
            exception.printStackTrace();
        }
    }
}
