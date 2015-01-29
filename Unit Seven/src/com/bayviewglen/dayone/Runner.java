package com.bayviewglen.dayone;

import java.util.Scanner;

public class Runner {
	private String firstName;
	private String lastName;
	private Time[] times;
	
	public static final int MILE_ONE = 0;
	public static final int MILE_TWO = 1;
	public static final int SPLIT_ONE = 0;
	public static final int SPLIT_TWO = 2;
	public static final int SPLIT_THREE = 3;
	public static final int FINAL = 4;
	
	private Runner(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		
		this.times = new Time[5];
	}
	
	public Runner(){
		this.times = new Time[5];
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setName(String name) {
		this.firstName = name.split(" ")[0];
		this.lastName = name.split(" ")[1];		
	}
	
	public String getName(){
		return firstName + " " + lastName;
	}

	public String toString(){
		String s = "Name: " + getName() + "\n";
		s += "Split One: " + times[SPLIT_ONE] + "\n";
		s += "Split Two: " + times[SPLIT_TWO] + "\n";
		s += "Split Three: " + times[SPLIT_THREE] + "\n";
		s += "Final: " + times[FINAL];
		
		return s;
	}
	
	public static Runner createRunner(Scanner s) {
		System.out.print("Please enter your name (first last): ");
		String name = s.nextLine();
		Runner r = new Runner();		
		r.setName(name);
		
		System.out.print("Please enter mile one time (mm:ss.sss): ");
		this.times[Runner.MILE_ONE] = new Time(s.nextLine());

		System.out.print("Please enter mile two time (mm:ss.sss): ");
		this.times[Runner.MILE_TWO] = new Time(s.nextLine());
		
		System.out.print("Please enter final time (mm:ss.sss): ");
		this.times[Runner.FINAL] = new Time(s.nextLine());
		r.processSplits();
		return r;
	}
	
	private void processSplits() {
		setTime(Runner.SPLIT_TWO, Time.difference(times[Runner.MILE_TWO], times[Runner.MILE_ONE]));
		setTime(Runner.SPLIT_THREE, Time.difference(times[Runner.FINAL], times[Runner.MILE_TWO]));
	}
}

