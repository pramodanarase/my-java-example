package org.core.java.collection;

import java.util.TreeSet;

public class TestTreeset {
	
	public static void main(String[] args) {
		
		MyObject o1 = new MyObject();
		MyObject o2 = new MyObject();
		
		TreeSet set = new TreeSet<>();
		
		set.add(o1);
		set.add(o1);

		
		System.out.println(set);
		
		
		
	}
	
	static class MyObject implements Comparable {

		@Override
		public int compareTo(Object o) {
			return 1;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}
	}

}
