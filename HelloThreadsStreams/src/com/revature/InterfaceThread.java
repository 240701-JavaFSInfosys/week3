package com.revature;

//This class implement Runnable - it's now a custom thread!
//We must override the run() method to give this thread its functionality
public class InterfaceThread implements Runnable {

    @Override
    public void run() {

        //this method will run through a for loop and print a message
        //we're gonna make some Threads race

        String name = Thread.currentThread().getName();

        System.out.println(name + " is starting!");

        for(int i = 0; i < 10; i++){
            System.out.println(name + " is on iteration: " + i);

            //Thread.sleep() forces a Thread to wait for x amount of milliseconds between runs
            //This method throws an InterruptedException, which is a Checked Exception. so we need try/catch
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println(name + " is finished!");

    }
}
