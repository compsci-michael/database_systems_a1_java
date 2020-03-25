package heap;  

public class HMethods {
	public static int P_FLAG = 0;
	public static int PAGE_SIZE_FLAG = 1;
	public static int DATA_FLAG = 2;
	
	// Method to Validate the Input Arguements
	public boolean input_validation(String[] args) {
		boolean is_correct = false;
		boolean override = false;
		// Step 1: Check if number of Arguements is Correct
		if(args.length < 3 || args.length > 3) {
			System.err.println("Error - Not Enough Arguements!");
			System.err.println("Format must be of the following: -p <pagesize> <datafilename>.csv\n");
		} else {
			// Correct number of Arguements, Validate Input
			// Check if -p exists
			if(args[P_FLAG].compareTo("-p") != 0) {
				System.err.println("Error - '-p' Flag is Missing!");
				override = true;
			}
			// Check if the pagesize was a number
			try {
		      int test_pagesize = Integer.parseInt(args[PAGE_SIZE_FLAG].trim());
		    } catch (NumberFormatException nfe) {
		      System.err.println("Error - That wasn't a Number!");
		      override = true;
		    }
			// Check if a .csv file was entered
			if(!args[DATA_FLAG].contains(".csv")) {
				System.err.println("Error - That wasn't a CSV file!");
				override = true;
			}
			if(!override) {
				is_correct = true;
			} else {
				System.err.println("Please try again!\n");
			}
		}
		return is_correct;	
	}
}
