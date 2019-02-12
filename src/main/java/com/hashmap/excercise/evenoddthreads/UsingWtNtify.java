package com.hashmap.excercise.evenoddthreads;

/**
 * Create two threads one will print only odd numbers and other will print even numbers.
 * Given 'current' print 1 to current numbers in order.
 */

class Print{
    int number;
    int current;

    public Print(int number){
        this.number = number;
        current = 1;
    }

    synchronized public void printOdd() throws InterruptedException {
        System.out.println((current++)+" "+Thread.currentThread().getName());
        notify();

        if(current<number)
            wait();

    }

    synchronized public void printEven() throws InterruptedException {
        System.out.println((current++)+" "+Thread.currentThread().getName());
        notify();

        if(current<current)
            wait();
    }
}

public class UsingWtNtify {

    public void printWithTwoThreads(int number) throws InterruptedException {

        Print print = new Print(number);

        new Thread(null, () -> {
            try {
                int i = 1;
                int end = 1;

                if (number % 2 == 0)
                    end = number / 2;
                else
                    end = number / 2 + 1;

                while (i <= end) {
                    print.printOdd();
                    i++;
                }

                //print.notifyAll();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Odd Thread").start();

        Thread.sleep(1000);


        new Thread(null, () -> {
            try {
                int i = 1;

                while (i <= (number / 2)) {
                    print.printEven();
                    i++;
                }
                //print.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "Even Thread").start();


    }

}