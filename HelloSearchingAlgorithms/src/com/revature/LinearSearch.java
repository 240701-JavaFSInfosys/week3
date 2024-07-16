package com.revature;

public class LinearSearch {

    public static void main(String[] args) {

        //Array of ints to search through
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        if(linearSearch(arr, 7) != -1){
            System.out.println("value found! Array index: " + linearSearch(arr, 7));
        }

        if(linearSearch(arr, 11) != -1){
            System.out.println("value found! Array index: " + linearSearch(arr, 11));
        } else {
            System.out.println("Value not found!");
        }

    }

    /* Linear Search
       - Simple (but inefficient) algorithm to search through a collection of data
       - It works by iterating through the data one by one until the target value is found
       - If we find the target value, we return its index.
       - If we reach the end of the collection, we return -1 (target not found).*/

    public static int linearSearch(int[] arr, int target){

        //using a regular for loop here for easy access to the index
        for(int i = 0; i < arr.length; i++){

            System.out.println("We are on index: " + i);

            if(arr[i] == target){
                return i; //value found! Return the index.
            }
        }

        return -1; //value not found!

    }

}
