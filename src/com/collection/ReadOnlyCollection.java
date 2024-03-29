package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReadOnlyCollection {

	public static void unmofiableList() {
		// List of Integer
        List<Integer> numbers = new ArrayList<>();
 
        // List have 1 to 10 numbers
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
 
        // Iterate on the stream of integers and
        // print them
        numbers.stream().forEach(System.out::print);
 
        // Now we are adding one more element
        numbers.add(11);
 
        // Removing element from the list
        numbers.remove(8);
 
        // Updating List¶
        numbers.set(4, 4);
 
        System.out.println("\nAfter Performing Some Operations");
 
        numbers.stream().forEach(System.out::print);
 
        System.out.println("\nHence By default Collections object is Readable and Writable");
 
        // Now making Read-Only List
        // Using unmodifiableList() method.
        try {
            numbers = Collections.unmodifiableList(numbers);
 
            // This line will generate an Exception
            numbers.remove(11);
        }
        catch (UnsupportedOperationException
                   unsupportedOperationException) {
            System.out.println(
                "Exceptions is "
                + unsupportedOperationException);
        }
        finally {
            System.out.println(numbers.get(3));
            System.out.println("Now list is only Read-Only");
        }
	}
	
	
	public static void main(String[] args) {
		
       unmofiableList();
	}

}
