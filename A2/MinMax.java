
public class MinMax {
	public static void main(String[] args) {
		int[] testArray = {5, 2, 199, 2, 6, 3, 1};
		System.out.println(minMaxAverage(testArray));
	}
	
	public static double minMaxAverage(int[] numbers) {
		if (numbers.length == 0) {
			throw new IllegalArgumentException("Array is empty");
		}
		int myMin;
		int myMax;
		int index;
		
		// check if array is even
		if (numbers.length % 2 == 0) {
			if (numbers[0] < numbers[1]) {
				myMin = numbers[0];
				myMax = numbers[1];
			} else {
				myMin = numbers[1];
				myMax = numbers[0];
			}
			index = 2;  // start from the 3rd element if even
		} else {
			myMin = numbers[0];
			myMax = numbers[0];
			index = 1; // start from the 2nd element if odd
		}
		
		//the pairing process
		while (index < numbers.length - 1) {
			int num1 = numbers[index];
			int num2 = numbers[index + 1];
			
			if (num1 < num2) {						// 1st comparison
				if (num1 < myMin) myMin = num1;		// 2nd 
				if (num2 > myMax) myMax = num2;		// 3rd
			} else {
				if (num1 > myMax) myMax = num1;		// 2nd
				if (num2 < myMin) myMin = num2;		// 3rd
			}
			index += 2;  // go to the next 2 numbers because the process needs 2 numbers to compare
		}
		return (myMin + myMax) /2.0;
	}
	/*
	 	Subtask II
	 	n is the number of elements in the input array
	 	
	 	Finding both minimum and maximum values we use pairing method (tournament)
	 	Which means we compare elements in pairs (2 elements at a time)
	 	What happen in each pair
	 		1. Compare the two element (to know which one is smaller/larger) -> 1 comparison
	 		2. Compare smaller to the myMin -> 1 comparison
	 		3. Compare larger to the myMax -> 1 comparison
	 	So there are 3 comparisons per pair (2 element)
	 	
	 	There are two cases
	 	1. If n is even
	 		- start by comparing the first two element -> comparison // if (numbers[0] < numbers[1])
	 		- this leaves (n - 2) elements which now is (n - 2) / 2 pairs
	 		- total comparisons = 1 + 3 * ((n - 2) / 2) = 1 + (3n - 6)/2 = (3n-6+2)/2  = (3n-4)/2 = 3n/2 - 2
	 		which ultimately means 3n/2 - 2 is lower than 3n/2
	 		
	 	2. if n is odd
	 		- we make myMin and myMax equal to the first element numbers[0] -> 0 comparison
	 		- the remaining is (n - 1) which will give (n - 1) / 2 pairs
	 		- total comparison = 3 * (n - 1) / 2 = (3n - 3) / 2 = 3n/2 - 1.5
	 		which ultimately means 3n/2 -1.5 is lower than 3n/2
	 		
	 	in both cases, the number of comparisons is less than 3n/2
	 */
}
