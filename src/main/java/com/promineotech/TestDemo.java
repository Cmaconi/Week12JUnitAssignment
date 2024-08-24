package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	
	//creating methods and JUnit test
	

	public int multiplyPositive(int a, int b) {
		if(a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both numbers must be positive!");		//throws exception if a or b is not positive
		}
		
		return a * b;								//return product of a & b
	}

	public int getRandomInt() {
		
		Random random = new Random();				//generates a random number between 1-10
		
		return random.nextInt(10) + 1;
	}

	public int randomNumberSquared() {
		int randomInt = getRandomInt();
		
		return randomInt * randomInt;				//returns the product of the integer squared
	}

}
