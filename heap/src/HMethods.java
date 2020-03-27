///////////////////////////////////////////////////////////////////////////////
// File Written by: Michael A (s3662507) (Last Edit: 27/03/2020)
// Database Systems - Assignment 01
// Purpose of this Class:
// This Class is used to hold useful functionalities that can be called upon
// in the main method
///////////////////////////////////////////////////////////////////////////////
import java.util.HashMap;

public class HMethods {
	///////////////////////////////////////////////////////////////////////////
	/////////////////////////////VALUES////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public static int P_FLAG = 0;
	public static int PAGE_SIZE_FLAG = 1;
	public static int DATA_FLAG = 2;
	public static int INT_BYTE_SIZE = 4;
	
	public static int CENSUS_YR = 0;
	public static int BLOCK_ID = 1;
	public static int PROP_ID = 2;
	public static int BASE_PROP_ID = 3;
	public static int BUILDING_NAME = 4;
	public static int STREET_ADDRESS = 5;
	public static int SUBURB= 6;
	public static int CONSTRUCT_YR = 7;
	public static int REFURBISHED_YR = 8;
	public static int NUM_FLOORS = 9;
	public static int SPACE_USAGE = 10;
	public static int ACCESS_TYPE = 11;
	public static int ACCESS_DESC = 12;
	public static int ACCESS_RATING = 13;
	public static int BICYCLE_SPACES = 14;
	public static int HAS_SHOWERS = 15;
	public static int X_COOR = 16;
	public static int Y_COOR = 17;
	public static int LOCATION = 18;
	
	
	// Method to Validate the Input Arguements
	public boolean input_validation(String[] args) {
		boolean is_correct = false;
		boolean override = false;
		// Step 1: Check if number of Arguements is Correct
		if(args.length < 3 || args.length > 3) {
			System.err.println("Error - Not Enough Arguements!");
			System.err.println("Format must be of the following: -p <pagesize> <datafilename>.csv\n");
		} else {
			// Step 2: Validate Input
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
		// Step 3: Return Value
		return is_correct;	
	}
	
	// Method to extract the Page Size
	public int page_size(String[] args) {
		return Integer.parseInt(args[PAGE_SIZE_FLAG].trim());
	}
	
	// Method to Print out Contents of HashMap
	public void print_hash_map(HashMap<String, Record> data) {
		for (String key : data.keySet()) {
			data.get(key).record_display();
		}
	}
	
	// Method to Convert 4 Byte Array to Binary Representation
	public String byte_to_bit(byte[] b) {
		String output = "";
		for(int i=0; i<INT_BYTE_SIZE; i++) {
			output = output+String.format("%8s", Integer.toBinaryString(b[i] & 0xFF)).replace(' ', '0');
		}
		return output;
	}
	
	// Method to Fill a Character Array full of # and Insert the String
	public char[] char_fill(String s, int size) {
		char[] result = new char[size];
		for(int i=0; i<size; i++) {
			result[i] = '#';
		}
		for(int i=0; i<s.length(); i++) {
			result[i] = s.charAt(i);
		}
		return result;
	}
	
	// Method to Create a Record
	public Record create_record(String[] data, int line_number) {
		Record new_record = new Record();
		boolean record_failed = false;
		try {
			// Do NULL Checks are Replace them with Integer.MAX_VALUE
			if(data[CONSTRUCT_YR].equals("")) data[CONSTRUCT_YR] = Integer.toString(Integer.MAX_VALUE);
			if(data[REFURBISHED_YR].equals("")) data[REFURBISHED_YR] = Integer.toString(Integer.MAX_VALUE);
			if(data[ACCESS_RATING].equals(""))data[ACCESS_RATING] = Integer.toString(Integer.MAX_VALUE);
			if(data[BICYCLE_SPACES].equals("")) data[BICYCLE_SPACES] = Integer.toString(Integer.MAX_VALUE);
			if(data[HAS_SHOWERS].equals("")) data[HAS_SHOWERS] = Integer.toString(Integer.MAX_VALUE);
			if(data[X_COOR].equals("")) data[X_COOR] = Integer.toString(Integer.MAX_VALUE);
			if(data[Y_COOR].equals("")) data[Y_COOR] = Integer.toString(Integer.MAX_VALUE);

			new_record.set_census_yr(Integer.parseInt(data[CENSUS_YR].trim()));
			new_record.set_block_id(Integer.parseInt(data[BLOCK_ID].trim()));
			new_record.set_prop_id(Integer.parseInt(data[PROP_ID].trim()));
			new_record.set_base_prop_id(Integer.parseInt(data[BASE_PROP_ID].trim()));
			new_record.set_construct_yr(Integer.parseInt(data[CONSTRUCT_YR].trim()));
			new_record.set_refurbished_yr(Integer.parseInt(data[REFURBISHED_YR].trim()));
			new_record.set_num_floors(Integer.parseInt(data[NUM_FLOORS].trim()));
			new_record.set_access_rating(Integer.parseInt(data[ACCESS_RATING].trim()));
			new_record.set_bicycle_spaces(Integer.parseInt(data[BICYCLE_SPACES].trim()));
			new_record.set_has_showers(Integer.parseInt(data[HAS_SHOWERS].trim()));
			new_record.set_x_coor(Float.parseFloat(data[X_COOR].trim()));
			new_record.set_y_coor(Float.parseFloat(data[Y_COOR].trim()));
		} catch(NumberFormatException nfe) {
			System.err.println("Error - Record Discarded "
		      		+ "- Record Contained Non-Numerical Value at Line: "+line_number+"! ");
			record_failed = true;
		}
		if(record_failed) {
			return null;
		} else {
			new_record.set_building_name(data[BUILDING_NAME]);
			new_record.set_street_address(data[STREET_ADDRESS]);
			new_record.set_suburb(data[SUBURB]);
			new_record.set_space_usage(data[SPACE_USAGE]);
			new_record.set_access_type(data[ACCESS_TYPE]);
			new_record.set_access_desc(data[ACCESS_DESC]);
			new_record.set_location(data[LOCATION]);
			return new_record;
		}
	}
}