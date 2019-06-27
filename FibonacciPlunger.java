
// This program calculates the elements of the fibonacci sequence in a unique way.
// It is basically an EXERCISE in understanding the inner workings of a recursive function. 
// The recursive method 'fiboElement' finds the nth element of the sequence in a traditional way...

// But--- as the method runs, ALL the elements of the sequence are also printed out.  The method does this by analyzing the pattern of its own
// recursive chain of arguments n.  This chain can be represented as a tree structure of n-values.  Embedded in the tree structure are ALL the
// elements of the fibonacci sequence-- if you know where to look !!

// Briefly:  The n-values take an initial plunge from n down to 1, as the function moves down the left-most branch of the tree to its "leaf".
// Then, as other branches are examined, n experiences a series of new highs/spikes. At each spike, the program prints out the running 
// total "leaf-count" (base cases n==1 and n==2).  These totals ARE the elements of the fibonacci series.   

// Diagram to be provided in a future version !!    

import java.util.Scanner;

public class FibonacciPlunger {
	
	static int baseCount = 0;	// counts occurrences  of n==1  and  n==2 (each of which adds +1 to the element being summed) 
	static String nList = "";	// keeps a record of arguments n
	static int nSpike = 0; // records successive new highs of argument n, after initial plunge of n values (plunge:  n, n-1, n-2,..., 1)
	static boolean plungeIsOver = false;	// prevents pre-mature assignment of values to nSpike, during initial plunge
	
	
	// recursive function.  PRINTS OUT fibonacci elements.  RETURNS only the final element.
	public static int fiboElement(int n) {
		if (n == 1) {
			plungeIsOver = true;	// permanently set to true after initial plunge down to n==1
		}
		
		
		// print out elements of fibonacci sequence, one per recursive iteration.      The tree branch structure of the recursive method is 
		// complex: The code in this if-statement captures n's initial plunge down to 1 (one) followed by its slow up-and-down crawl back up to n-2.
		if (plungeIsOver  &&  n > nSpike) {
			System.out.print(Integer.toString(baseCount) + ",");	// print out one element
			nSpike = n;	//update nSpike to new high value
		}
		nList += Integer.toString(n) + ",";		// generate string for user containing all values of n
		
		
		// Here is the recursion
		if (n == 2 || n == 1) {		// two base cases
			baseCount += 1;		// counter is used by if-block above to calculate each element to be printed
			return 1;
		}
		else {
			return fiboElement(n - 1) + fiboElement(n - 2);		// Call the function recursively  [traditional fibonacci code]
		}
	}
	
	
	public static void main(String[] arg) {
		// Display information, get integer input from user
		Scanner scanObj = new Scanner(System.in);
		System.out.println("\nLeonardo Fibonacci was a 12th Century Italian mathematician who traveled widely around the Mediterranean. He encouraged Europeans to toss out \ntheir Roman numerals (Welcome to the 12th century, people!) and replace them with Hindu-Arabic numerals. He also got a great sequence named after himself.");
		System.out.print("\nHow many elements of the Fibonacci sequence would you like to see?  Please enter a smallish integer: ");
		int fiboQuery = scanObj.nextInt();
		
		// call method. Print out fibonacci series in three steps
		System.out.print("The first " + fiboQuery + " elements of the Fibonacci sequence are:  1,");// 1. print first element "1". Method won't calc it
		int endInt = fiboElement(fiboQuery);	// 2. print elements of sequence as method runs
		System.out.println(endInt);				// 3. print final element (the method return) 

		// Display information, user hits enter
		System.out.print("\nOkay, no big deal, but the recursive programming involved IS deceptively difficult and delightful !! "
				+ "\nThe recursive function 'fiboElement' only returns the final number of the sequence, in this case " + Integer.toString(endInt) 
				+ ". It prints the other numbers as it runs, by analyzing \nits own successive arguments n.  After an initial plunge "
				+ "of the values of n, from " + Integer.toString(fiboQuery) + " down to 1, it looks for a series of highs, or spikes, in the values of n. "
				+ "\n\nHit <enter> to see the successive values of argument n:    ");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		
		// Print list of arguments n
		System.out.print(nList.substring(0,nList.length() - 1) + "   (do you see the initial plunge, followed by highs/spikes?)");
		System.out.println("\nThat's the brief overview.  Let's hear it for recursive functions!");
		scanObj.close();
		input.close();
	}
}
