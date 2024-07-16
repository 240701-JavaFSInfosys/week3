package com.revature;

public class BinarySearch {

    public static void main(String[] args) {

        //Array of ints to search through
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        if(binarySearch(arr, 8) != -1){
            System.out.println("Value found! Array index: " + binarySearch(arr, 8));
        }

        if(binarySearch(arr, 18) != -1){
            System.out.println("Value found! Array index: " + binarySearch(arr, 18));
        } else {
            System.out.println("Value not found!");
        }

    }

    /* Binary Search
       -Binary Search is a more complex but more efficient algorithm compared to linear search
       -It works by comparing the target to the middle element of the Array
       -If the target is less than the middle element, we search the left half of the Array
       -If the target is greater than the middle element, we search the right half of the Array
       -We repeat this process on the half of the Array that we know the target is in
       -We continue this process until we find the target, or determine that it's not in the Array
       -NOTE: Binary search only works on SORTED collections of data.
            -So we should make sure our collection is sorter before attempting Binary Search */
    public static int binarySearch(int[] arr, int target){

        //start with a counter, to determine the first and last index
        int left = 0;
        int right = arr.length - 1;

        //while the left pointer is <= the right pointer...
        while(left <= right){

            //find the middle index
            int mid = left + (right - left) / 2; //ex: 0 + (9 - 0) / 2 = 4.5 (But int rounds down to 4)

            System.out.println("Middle index is: " + mid);

            //if the middle index == our target, we found it! return the index
            if(arr[mid] == target){
                return mid; // :)
            }

            //if the target is greater than the middle element, ignore the left half
            if(arr[mid] < target){
                left = mid + 1; //move the left pointer to the right of the middle
            } else {
                //if the target is less than the middle element, ignore the right half
                right = mid - 1; //move the right pointer to the left of the middle
            }

        }

        //if the while loop breaks and we haven't found our target, it's not in the Array!
        return -1;

    }

}
