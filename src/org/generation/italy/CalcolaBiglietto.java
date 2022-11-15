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
		if(tripDistance <= 0) {
			System.out.println("Please insert a valid value for the trip.");
			sc.close();
			return;
		} else {
			System.out.println("You selected a distance of " + tripDistance + "km");
		}
		
		sc.close();
		
		double finalPricePerKm = initialPricePerKm;
		
		if (userAge < 12) {
			System.out.println("Under 12 customers travel free!");
			return;
		} else if (userAge < 18) {
			
			finalPricePerKm = finalPricePerKm - (finalPricePerKm * under18Discount / 100.0);
		} else if (userAge > 65) {
			
			finalPricePerKm = finalPricePerKm - (finalPricePerKm * over65Discount / 100.0);
		}
		
		double totalTripPrice = 0.00;
		
		for(int i = 1; i <= tripDistance; i++) {
			
			double costIncrement = (i - 1) * 0.01;
			
			if(i == 1) {
				costIncrement = 0;
			}
			
			double incrementedPricePerKm = finalPricePerKm + costIncrement;
			totalTripPrice = totalTripPrice + incrementedPricePerKm;
			System.out.println(totalTripPrice);
		}
		
		System.out.printf("The final cost is: %.02f €", totalTripPrice);
	}
}
