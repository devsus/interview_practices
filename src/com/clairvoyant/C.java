package com.clairvoyant;

class A{
	public A() {
		System.out.println("A");
	}
}

class B extends A{
	public B() {
		System.out.println("B");
	}
}
public class C extends B {
	public C() {
		System.out.println("C");
	}
	public static void main(String[] args) {
		C c = new C();
		
		A a = new C();

	}

}
