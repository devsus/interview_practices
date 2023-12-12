package com.interviews;

public final class FinalClassExample {
	
	private final int id;
	private final String name;
	private final String address;
	public FinalClassExample(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}

}
