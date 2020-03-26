package heap;

public class dbload {
	
	// Executable Name must be dbload
	// Must be able to execute the following: java dbload -p pagesize datafile
	public static void main(String[] args) {
		HMethods hm = new HMethods();
		boolean correct_input = hm.input_validation(args);
		if(correct_input) {
			int page_size = hm.page_size(args);
			String building_name = "Building Name";
			String street_address = "Street Address";
			String suburb = "Suburb";
			String space_usage = "Space Usage";
			String access_type = "Access Type";
			String access_desc = "Access Desc";
			String location = "(34.32312, -142.03123)";

			Record new_record = new Record(1,1,1,1,building_name, street_address, suburb, 2018, 2001, 2, space_usage, access_type, access_desc, 0, 1800, 1, 34.32312, -142.03123, location);
			new_record.record_display();
			// Basic Maths of Records
			// Fixed: Num of Records per Page = page_size/record_leng
			// Variable: Use Counter
			// Using Basic Maths, if Fixed, 48+70+40+35+45+35+85 = 358
			// 4096/358 = 11 Records per Page
			// It is known that there is 220,950 Records
			// 220,950/11 = 20,087 Pages which is 220,950*358 = 79,100,100 Bytes
			// However, space needs to be left at the end of the page so,
			// 10 Records per Page = 220,950/10 = 22095 Pages => 22095*4096 = 90,501,120 Bytes
			
			
			// Heap does not need Header (containing things like the #
			//  of Records in the File or Free Space List)
			// Might need to keep a count of Records in each Page
			// File should be packed, i.e. no gap between records
			// a Gap at the end of each Page is required
			
			// Must output to stdout 
			// Number of Records Loaded
			// Number of Pages used
			// Number of Milliseconds to create the Heap File
		}
	}
}
