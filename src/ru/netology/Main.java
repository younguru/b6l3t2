package ru.netology;

import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final int STARTNUMBER = 0;
        final int ENDNUMBER = 6;

        LongAdder summer = new LongAdder();

        Thread thread1 = new Thread(null, () -> IntStream.range(STARTNUMBER, ENDNUMBER + 1).forEach(summer::add), "Поток 1");
        Thread thread2 = new Thread(null, () -> IntStream.range(STARTNUMBER, ENDNUMBER + 1).forEach(summer::add), "Поток 2");
        Thread thread3 = new Thread(null, () -> IntStream.range(STARTNUMBER, ENDNUMBER + 1).forEach(summer::add), "Поток 3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("\nРезультат: " + summer.sum());
    }
}
