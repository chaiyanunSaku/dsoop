
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
	
}
