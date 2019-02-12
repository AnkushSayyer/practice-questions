package com.hashmap.excercise.evenoddthreads;

/**
 * Create two threads one will print only odd numbers and other will print even numbers.
 * Given 'current' print 1 to current numbers in order.
 */


public class UsingThreadSleep {

    public void printWithTwoThreads(int number) {


        new Thread(null,()->{
            int current=0;
            while (current<=number){
                System.out.println(current);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                current+=2;
            }

        },"Eevn Thread").start();

        new Thread(null,()->{
            int current=1;
            while (current<=number){
                System.out.println(current);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                current+=2;
            }

        },"Odd Thread").start();



    }

}
