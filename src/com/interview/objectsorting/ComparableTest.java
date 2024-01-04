package com.interview.objectsorting;

import java.util.Collections;
import java.util.LinkedList;

public class ComparableTest implements Comparable<ComparableTest> {
	private Integer id;
	private String name;
	private Integer rollno;

	public ComparableTest( String name, Integer id, Integer rollno) {
		super();
		this.id = id;
		this.name = name;
		this.rollno = rollno;
	}
	/*
	@Override
	public int compareTo(ComparableTest c) {
		if(id>c.id) {
			return 1; //descending order
		}else if(id==c.id) {
			return 0;
		}else {
			return -1;
		}
		
	}
	*/
	
	@Override
	public int compareTo(ComparableTest c) {
	    return this.name.compareTo(c.name);
	}

	public static void main(String[] args) {
		// Create one LinkedList for Student object
        LinkedList<ComparableTest> List
            = new LinkedList<ComparableTest>();
        List.add(new ComparableTest("Meet", 32, 2));
        List.add(new ComparableTest("Jhon", 11, 5));
        List.add(new ComparableTest("Sham", 92, 1));
        List.add(new ComparableTest("William", 86, 3));
        List.add(new ComparableTest("Harry", 35, 4));
        System.out.println("before sorting-------------------------");
        
        for (ComparableTest s : List) {
        	System.out.println(s.name + " " + s.id + " "+ s.rollno);
			
		}
        System.out.println("after sorting---------------------------");
        Collections.sort(List);
        for (ComparableTest s : List) {
        	System.out.println(s.name + " " + s.id + " "+ s.rollno);
			
		}
        
        Collections.sort(List,Collections.reverseOrder());
        System.out.println("sorting in revers order-----------------");
        for (ComparableTest s : List) {
        	System.out.println(s.name + " " + s.id + " "+ s.rollno);
			
		}

	}
	

}
