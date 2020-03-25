package heap;

public class HMethods {
	// Method to Validate the Input Arguements
	public boolean input_validation(String[] args) {
		boolean is_correct = false;
		// Step 1: Check if number of Arguements is Correct
		if(args.length < 2 || args.length > 2) {
			System.err.println("Error - Not Enough Arguements!");
			System.err.println("Format must be of the following: -p <pagesize> <datafile>\n");
		} else {
			// Correct number of Arguements, Validate Input
			if(args[0].compareTo("-p") != 0) {
				System.err.println("Error - '-p' Flag is Missing!");
				System.err.println("Please try again!\n");
			}
		}
		return is_correct;	
	}
}
