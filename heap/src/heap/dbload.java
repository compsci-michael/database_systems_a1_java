package heap;

public class dbload {
	
	// Executable Name must be dbload
	// Must be able to execute the following: java dbload -p pagesize datafile
	public static void main(String[] args) {
		HMethods hm = new HMethods();
		boolean correct_input = hm.input_validation(args);
		System.out.println(correct_input);
		// Heap does not need Header (containing things like the # of Records in the File or Free Space List
		// Might need to keep a count of Records in each Page
		// File should be packed, i.e. no gap between records
		// a Gap at the end of each Page is required
		
		// Must output to stdout 
		// Number of Records Loaded
		// Number of Pages used
		// Number of Milliseconds to create the Heap File
	}
}
