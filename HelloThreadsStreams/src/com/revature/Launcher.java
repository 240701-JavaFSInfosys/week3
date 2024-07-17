package com.revature;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        System.out.println("===================(Streams)");

        //Create a Stream of Integers
        IntStream.range(0, 10).skip(3).forEach(System.out::println);
        /*The stream will have values 1-9 (range() - intermediate)
         The stream will skip the first 3 values (skip() - intermediate)
         FOR EACH value in the stream, print the value(forEach() - terminal)

         What is System.out::println? It's called "method reference syntax" (in week 2 of the curriculum)
         You may notice we never said what value to print in the print statement
         Method reference syntax let's us imply the value that a method will take as a parameter*/

        //Stream.of() is a convenient way to create a Stream of any object. The data must be of the same type
        Optional<String> string = Stream.of("ok", "ummm", "Ben", "Revature", "Scooby Doo", "Alright")
                .sorted() //this will sort the elements in their natural order (alphabetical in this case)
                .findFirst(); //this will return the first element in the Stream as an OPTIONAL

        /*ok what is an Optional? It's a Java class that will either hold a value or be empty
        it will OPTIONALLY hold a value. This is useful when we potentially have a null value
        great way to avoid NullPointerExceptions, but we need to extract the value in a certain way*/
        if(string.isPresent()){
            System.out.println(string.get());
        }
        //we've effectively found the first alphabetical value in the stream

        //Let's use a Stream on a predefined ArrayList to create a new ArrayList
        List<String> names = new ArrayList<>(); //downcasting to ArrayList - we can treat this List as an ArrayList

        names.add("Ben");
        names.add("Jamie");
        names.add("Sai");
        names.add("Nathan");
        names.add("Ted");
        names.add("Scooby Doo");
        names.add("Scooby Doo");
        names.add("Revature");

        List<String> newNames = names.stream()
                .distinct() //knocks out any duplicate values (the first Scooby Doo)
                .sorted()
                .filter(element -> element.length() < 10) //keep elements less than 10 characters (the 2nd Scooby)
                .toList();

        //print out the processed names
        System.out.println(newNames);

        //quick example of Reflection API
        Class<Thread> threadClassForReflection = Thread.class;

        for(Method m : threadClassForReflection.getMethods()){
            System.out.println(m.getName());
        }

    }
}