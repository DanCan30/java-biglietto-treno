package org.generation.italy;

import java.util.Scanner;

public class CalcolaBiglietto {
	public static void main(String[] args) {
		
		double initialPricePerKm = 0.21;
		byte under18Discount = 20;
		byte over65Discount = 40;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How old are you? ");
		int userAge = sc.nextInt();
		System.out.println("Your age: " + userAge);
		
		System.out.print("How long will be the trip? ");
		int tripDistance = sc.nextInt();
		System.out.println("You selected a distance of " + tripDistance + "km");
		
		sc.close();
		
		double finalPricePerKm = 0.0;
		
		for(int i = 0; i <= tripDistance; i++) {
			double costIncrement = i * 0.01;
			finalPricePerKm = initialPricePerKm + costIncrement;
			System.out.println(finalPricePerKm);
		}
		
		double totalTripPrice = tripDistance * finalPricePerKm;
		
		if (userAge < 12) {
			System.out.println("Under 12 customers travel free!");
			return;
		} else if (userAge < 18) {
			
			totalTripPrice = totalTripPrice - (totalTripPrice * under18Discount / 100.0);
		} else if (userAge > 65) {
			
			totalTripPrice = totalTripPrice - (totalTripPrice * over65Discount / 100.0);
		}
		
		System.out.printf("The final cost is: %.02f €", totalTripPrice);
	}
}
