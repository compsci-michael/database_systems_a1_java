///////////////////////////////////////////////////////////////////////////////
// File Written by: Michael A (s3662507) (Last Edit: 27/03/2020)
// Database Systems - Assignment 01
// Purpose of this Class:
// This class was created to store all the Record related data
// This class is used in conjuction with the Slot and Page classes to create a 
// heap
///////////////////////////////////////////////////////////////////////////////

//0: census_yr, 1: block_id, 2: prop_id, 3: base_prop_id, 
//4:building_name, 5: stree_address, 6: suburb, 7: construct_yr,
//8: refurbished_year, 9: num_floors, 10: space_usage, 11: access_type,
//12: access_desc, 13: access_rating, 14: bicycle_spaces,
//15: has_showers, 16: x_coor, 17: y_coor, 18:location

//0: int, 1: int, 2: int, 3: int, 4: VARCHAR(63), 5: VARCHAR(34)
//6: VARCHAR(28), 7: int, 8: int, 9: int, 10: VARCHAR(39),
//11: VARCHAR(32), 12: VARCHAR(81), 13: int, 14: int, 15: int,
//16: double, 17: double, 18: VARCHAR(27)

public class Record {
	///////////////////////////////////////////////////////////////////////////
	////////////////ATTRIBUTES (FIELDS IN THE FLAT FILE)///////////////////////
	///////////////////////////////////////////////////////////////////////////
	private int census_yr;
	private int block_id;
	private int prop_id;
	private int base_prop_id;
	private char[] building_name = new char[63];
	private char[] street_address = new char[34];
	private char[] suburb = new char[28];
	private int construct_yr;
	private int refurbished_yr;
	private int num_floors;
	private char[] space_usage = new char[39];
	private char[] access_type = new char[32];
	private char[] access_desc = new char[81];
	private int access_rating;
	private int bicycle_spaces;
	private int has_showers;
	private double x_coor;
	private double y_coor;
	private char[] location = new char[27];
		
	///////////////////////////////////////////////////////////////////////////
	//////////////////////////DEFAULT CONSTRUCTOR//////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public Record() {
		
	}
	
	///////////////////////////////////////////////////////////////////////////
	/////////////////////////OVERRIDE CONSTRUCTOR//////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public Record(int census_yr, int block_id, int prop_id, int base_prop_id,
			String building_name, String street_address, String suburb,
			int construct_yr, int refurbished_yr, int num_floors,
			String space_usage, String access_type, String access_desc,
			int access_rating, int bicycle_spaces, int has_showers,
			double x_coor, double y_coor, String location) {
		this.census_yr = census_yr;
		this.block_id = block_id;
		this.prop_id = prop_id;
		this.base_prop_id = base_prop_id;
		this.set_building_name(building_name);
		this.set_street_address(street_address);
		this.set_suburb(suburb);
		this.construct_yr = construct_yr;
		this.refurbished_yr = refurbished_yr;
		this.num_floors = num_floors;
		this.set_space_usage(space_usage);
		this.set_access_type(access_type);
		this.set_access_desc(access_desc);
		this.access_rating = access_rating;
		this.bicycle_spaces = bicycle_spaces;
		this.has_showers = has_showers;
		this.x_coor = x_coor;
		this.y_coor = y_coor;
		this.set_location(location);		
	}
	
	// This Method displays all the details of the Record for Debugging Purposes
	public void record_display() {
		System.out.println("Census Year: "+this.get_census_yr());
		System.out.println("Block ID: "+this.get_block_id());
		System.out.println("Property ID: "+this.get_prop_id());
		System.out.println("Base Property ID: "+this.get_base_prop_id());
		this.display_char_array(this.get_building_name(), "Building Name: ", false);
		this.display_char_array(this.get_street_address(), "Street Address: ", false);
		this.display_char_array(this.get_suburb(), "Suburb: ", false);
		System.out.println("Construction Year: "+this.get_construct_yr());
		System.out.println("Refurbished Year: "+this.get_refurbished_yr());
		System.out.println("Number of Floors: "+this.get_num_floors());
		this.display_char_array(this.get_space_usage(), "Space Usage: ", false);
		this.display_char_array(this.get_access_type(), "Access Type: ", false);
		this.display_char_array(this.get_access_desc(), "Access Description: ", false);
		System.out.println("Access Rating: "+this.get_access_rating());
		System.out.println("Bicycle Spaces: "+this.get_bicycle_spaces());
		System.out.println("Has Showers: "+this.get_has_showers());
		System.out.println("X Coordinate: "+this.get_x_coor());
		System.out.println("Y Coordinate: "+this.get_y_coor());
		this.display_char_array(this.get_location(), "Location: ", false);	
		System.out.println();
	}
	
	// This Method displays unique information of the Record for Debugging
	public void record_display_simple() {
		System.out.print("Census Year: "+this.get_census_yr()+", ");
		System.out.print("Block ID: "+this.get_block_id()+", ");
		System.out.print("Property ID: "+this.get_prop_id()+", ");
		System.out.print("Base Property ID: "+this.get_base_prop_id()+", ");
		this.display_char_array(this.get_building_name(), "Building Name: ", true);
		this.display_char_array(this.get_street_address(), "Street Address: ", true);
		this.display_char_array(this.get_suburb(), "Suburb: ", true);
		System.out.print("Construction Year: "+this.get_construct_yr()+", ");
		System.out.println();
	}	
	
	// This Method to Display the Character Array in the Record
	public void display_char_array(char[] str, String display, boolean is_simple) {
		System.out.print(display);
		for(int i=0; i<str.length; i++) {
			if(str[i] != '#') {
				System.out.print(str[i]);	
			} else {
				break;
			}
		}
		if(is_simple) {
			System.out.print(", ");
		} else {
			System.out.println();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////
	////////////////////////////////GETTERS////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	public int get_census_yr() {
		return census_yr;
	}
	public int get_block_id() {
		return block_id;
	}
	public int get_prop_id() {
		return prop_id;
	}
	public int get_base_prop_id() {
		return base_prop_id;
	}
	public char[] get_building_name() {
		return building_name;
	}
	public char[] get_street_address() {
		return street_address;
	}
	public char[] get_suburb() {
		return suburb;
	}
	public int get_construct_yr() {
		return construct_yr;
	}
	public int get_refurbished_yr() {
		return refurbished_yr;
	}
	public int get_num_floors() {
		return num_floors;
	}
	public char[] get_space_usage() {
		return space_usage;
	}
	public char[] get_access_type() {
		return access_type;
	}
	public char[] get_access_desc() {
		return access_desc;
	}
	public int get_access_rating() {
		return access_rating;
	}
	public int get_bicycle_spaces() {
		return bicycle_spaces;
	}
	public int get_has_showers() {
		return has_showers;
	}
	public double get_x_coor() {
		return x_coor;
	}
	public double get_y_coor() {
		return y_coor;
	}
	public char[] get_location() {
		return location;
	}

	
	///////////////////////////////////////////////////////////////////////////
	////////////////////////////////SETTERS////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////	
	public void set_census_yr(int census_yr) {
		this.census_yr = census_yr;
	}
	public void set_block_id(int block_id) {
		this.block_id = block_id;
	}
	public void set_prop_id(int prop_id) {
		this.prop_id = prop_id;
	}
	public void set_base_prop_id(int base_prop_id) {
		this.base_prop_id = base_prop_id;
	}
	public void set_building_name(String building_name) {
		HMethods hm = new HMethods();
		this.building_name = hm.char_fill(building_name, 63);
	}
	public void set_street_address(String street_address) {
		HMethods hm = new HMethods();
		this.street_address = hm.char_fill(street_address, 34);
	}
	public void set_suburb(String suburb) {
		HMethods hm = new HMethods();
		this.suburb = hm.char_fill(suburb, 28);
	}
	public void set_construct_yr(int construct_yr) {
		this.construct_yr = construct_yr;
	}
	public void set_refurbished_yr(int refurbished_yr) {
		this.refurbished_yr = refurbished_yr;
	}
	public void set_num_floors(int num_floors) {
		this.num_floors = num_floors;
	}
	public void set_space_usage(String space_usage) {
		HMethods hm = new HMethods();
		this.space_usage = hm.char_fill(space_usage, 39);
	}
	public void set_access_type(String access_type) {
		HMethods hm = new HMethods();
		this.access_type = hm.char_fill(access_type, 32);
	}
	public void set_access_desc(String access_desc) {
		HMethods hm = new HMethods();
		this.access_desc = hm.char_fill(access_desc, 81);
	}
	public void set_access_rating(int access_rating) {
		this.access_rating = access_rating;
	}
	public void set_bicycle_spaces(int bicycle_spaces) {
		this.bicycle_spaces = bicycle_spaces;
	}
	public void set_has_showers(int has_showers) {
		this.has_showers = has_showers;
	}
	public void set_x_coor(double x_coor) {
		this.x_coor = x_coor;
	}
	public void set_y_coor(double y_coor) {
		this.y_coor = y_coor;
	}
	public void set_location(String location) {
		HMethods hm = new HMethods();
		this.location = hm.char_fill(location, 27);
	}
	
	// Method for Searching for a String in the Record
	public boolean contains(String sc) {
		if(sc.equals("#")) {
			sc = "###############################################################";
		}
		if(new String(this.building_name).toLowerCase().contains(sc.toLowerCase())) {
			return true;
		}
		return false;
	}
}
