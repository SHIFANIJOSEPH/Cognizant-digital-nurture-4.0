package com.cognizant;

public class RecursionTest {
	public static void main(String[] args) {
		
		int time = 10;
		double growth = 0.05;
		double initial = 10000;
		long startTime = System.currentTimeMillis();
		double future = FinancialForecast.predictFuture(time,growth,initial);
		
		long endTime = System.currentTimeMillis();
		
		System.out.printf("Future value after %d years: Rs.%.2f",time,future);
		System.out.println("Time taken: " + (endTime - startTime) + " ms");
	}
}
class FinancialForecast{
	public static double predictFuture(int time,double growth,double initial){
		//FutureValue(n)=FutureValue(n−1)×(1+growthRate)
		if(time == 0) {
			return initial;
		}
		return predictFuture(time-1,growth,initial)*(1+growth);
	}
}
