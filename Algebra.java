import javax.tools.FileObject;

// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {

		if (x2 >= 0) {
		for (int i = 0; i < x2; i++) { 
			x1++;
			}
		}
		else {
			for (int j = x2; j < 0; j++) {
				x1--;
			}
		}

		int res = x1;

		return res;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {

		if (x2 >= 0) {
			for (int i = 0; i < x2; i++) { 
				x1--;
			}
		}
		else {
			for (int j = x2; j < 0; j++) { 
				x1++;
		}
	}
		int res = x1;

		return res;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int res = 0;
		
		if (x1 < 0 && x2 < 0) {
			x1 = minus(0, x1);
			x2 = minus(0, x2);
		
			for (int i = 0; i < x2; i++) {
				int c = plus(x1, res);
				res = c;
			}
		}
		else {
			for (int i = 0; i < x2; i++) {
				int c = plus(x1, res);
				res = c;
			}
		}
		return res;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int base = x;
		int power = n; 
		int res = 1;

		if (x < 0 && mod(n, 2) == 0) {
			for (int i = 0; i < power; i++) {
				int c = times(base, res);
				res = c;
			}
			return res = minus(0, res);
		}
		else {
			for (int i = 0; i < power; i++) {
				int c = times(base, res);
				res = c;
			}
		}
		
		return res;
	}

	// Returns the integer part of x1 / x2
	public static int div(int x1, int x2) {
		int nominator = x1;
		int denominator = x2;
		int counter = 0;

		if (nominator < 0 && denominator < 0) {
			x1 = minus(0, x1);
			x2 = minus(0, x2);
			
			while (minus(nominator, denominator) <= 0) {

				int c = minus(nominator, denominator); 
				nominator = c; 
				counter++;

			}
		}
		if (nominator < 0 && denominator > 0) {
			while (plus(nominator, denominator) >= 0) {

				int c = plus(nominator, denominator); 
				nominator = c;
				counter++;
			}
		}
		if (nominator > 0 && denominator > 0) {
			while (minus(nominator, denominator) >= 0) {

				int c = minus(nominator, denominator); 
				nominator = c;
				counter++;
 
			}
		}
		return counter;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int nominator = x1;
		int denominator = x2;
		
		while(minus(nominator, denominator) >= 0) {

			int c = minus(nominator, denominator); 
			nominator = c;

		}

		return nominator;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {

		int res = 0;
		if (x == 0) {
			return 0;
		}
		while (times(res, res) <= x) {
			res = plus(res, 1);
		}
		res = minus(res, 1);


		return res;  
	}	  
}
