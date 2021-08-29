package com;

import java.util.Scanner;

public class CabInvoice {
	public static void main(String[] args) {
		invoice();
	}
	public static void invoice() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Total Number of rides: ");
		Integer n =sc.nextInt();
		Float totalCost = RideCalculate.multiRideFare(n);
		Float avgCost = totalCost/n;
		System.out.println("Total Numbers of Fare: "+n);
		System.out.println("Total Fare: "+totalCost);
		System.out.println("Avg Fare per ride: "+avgCost);
	}
}

class RideCalculate{
	public static Integer Ridetype = 10;
	
	public static Float totalFare(float distance, float time) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Type of Ride: 1. Normal or 2. Premium (1 or 2): ");
		Ridetype=(sc.nextInt()==1)?10:20;
		Float cost = distance*Ridetype+time;
		return (cost>5)?cost:5;
	}
	
	public static Float multiRideFare(Integer n) {
		Float totalMultiRideFare = 0.0f;
		Scanner sc =new Scanner(System.in);
		for(int i =0; i<n;i++) {
			System.out.println("Enter Distance for ride"+(i+1)+" : ");
			Float d=sc.nextFloat(); 
			System.out.println("Enter Time for ride"+(i+1)+" : ");
			Float t=sc.nextFloat();
			totalMultiRideFare +=totalFare(d, t);
		}
		return totalMultiRideFare;
	}
}
