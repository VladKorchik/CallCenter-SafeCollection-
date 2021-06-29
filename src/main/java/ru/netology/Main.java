package ru.netology;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    final static int quantityOfOperator = 10;

    public static void main(String[] args) throws InterruptedException {

        LinkedBlockingQueue callsQueue = new LinkedBlockingQueue();

        Thread atx = new AutomaticTelephoneExchange(callsQueue);
        atx.start();

        for (int i = 0; i < quantityOfOperator; i++) {
            Thread operator = new Operator(callsQueue, "Оператор " + i);
            operator.start();
        }
    }
}
