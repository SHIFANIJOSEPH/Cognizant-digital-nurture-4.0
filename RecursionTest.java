package com.cognizant;

/*

When years becomes large (e.g., 10,000+), recursion can cause:

StackOverflowError

Slower execution due to deep call stack

Use Iteration (Best Option)
Avoid recursion altogether and use a simple loop:

public static double predictFutureValueIterative(int years, double initialValue, double growthRate) {
    double result = initialValue;
    for (int i = 0; i < years; i++) {
        result *= (1 + growthRate);
    }
    return result;
}
*/

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
