import java.util.Scanner; // Imports scanner


	class StringSetTester // Class header
	{
		public static void main(String[] args) // Main Method
		{
			// This is where you input your strings into the array
			Scanner kybd = new Scanner(System.in);
			System.out.print("How many strings will you enter? ");
			int numStr = kybd.nextInt();
			kybd.nextLine();

			StringSet ss = new StringSet(); // Tester object
			
			// This is where you enter the text however any amount of strings you entered into the Scanner
			for(int i = 0; i < numStr; i++)
			{
				System.out.print("Enter string " + (i+1) + ": ");
				String temp = kybd.nextLine();
				ss.add(temp);
			}
			
			// Output lines for each method
			System.out.println("The size of the StringSet is: " + ss.size());
			ss.pop();
			System.out.println("The size of the StringSet is: " + ss.size());
			System.out.println("The number of characters in StringSet is: " + ss.numChars());
			System.out.println("The number of strings in StringSet is: " + ss.countStrings("hi"));

		}

	}

