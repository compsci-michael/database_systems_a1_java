package heap;

// 0: census_yr, 1: block_id, 2: prop_id, 3: base_prop_id, 
// 4:building_name, 5: stree_address, 6: suburb, 7: construct_yr,
// 8: refurbished_year, 9: num_floors, 10: space_usage, 11: access_type,
// 12: access_desc, 13: access_rating, 14: bicycle_spaces,
// 15: has_showers, 16: x_coor, 17: y_coor, 18:location

// 0: int, 1: int, 2: int, 3: int, 4: VARCHAR(70), 5: VARCHAR(40)
// 6: VARCHAR(35), 7: int, 8: int, 9: int, 10: VARCHAR(45),
// 11: VARCHAR(35), 12: VARCHAR(85), 13: int, 14: int, 15: int,
// 16: double, 17: double, 18: VARCHAR(35)

public class dbload {
	
	// Executable Name must be dbload
	// Must be able to execute the following: java dbload -p pagesize datafile
	public static void main(String[] args) {
		HMethods hm = new HMethods();
		boolean correct_input = hm.input_validation(args);
		if(correct_input) {
			int page_size = hm.page_size(args);
			
			// Basic Maths of Records
			// Fixed: Num of Records per Page = page_size/record_leng
			// Variable: Use Counter
			// Using Basic Maths, if Fixed, 48+70+40+35+45+35+85 = 358
			// 4096/358 = 11 Records per Page
			// It is known that there is 220,950 Records
			// 220,950/11 = 20,087 Pages which is 220,950*358 = 79,100,100 Bytes

			
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
