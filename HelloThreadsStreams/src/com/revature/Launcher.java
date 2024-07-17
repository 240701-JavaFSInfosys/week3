package com.revature;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("====================(Threads)");

        //Instantiate two Threads (both from InterfaceThread)
        InterfaceThread t1 = new InterfaceThread();
        InterfaceThread t2 = new InterfaceThread();

//        t1.run();
//        t2.run();

        //This doesn't look concurrent at all... we didn't actually create new instance of our Thread!
        //we need to use the start() method for that. This is why we see "main" is working

        //run thread 1
        Thread thread1 = new Thread(t1);
        thread1.start();

        //run thread 2
        Thread thread2 = new Thread(t2);
        thread2.start();

        //run a third thread - note that it doesn't matter if we use t1 or t2.
        Thread thread3 = new Thread(t1);
        thread3.start();

    }
}
