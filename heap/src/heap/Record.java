package heap;

//0: census_yr, 1: block_id, 2: prop_id, 3: base_prop_id, 
//4:building_name, 5: stree_address, 6: suburb, 7: construct_yr,
//8: refurbished_year, 9: num_floors, 10: space_usage, 11: access_type,
//12: access_desc, 13: access_rating, 14: bicycle_spaces,
//15: has_showers, 16: x_coor, 17: y_coor, 18:location

//0: int, 1: int, 2: int, 3: int, 4: VARCHAR(70), 5: VARCHAR(40)
//6: VARCHAR(35), 7: int, 8: int, 9: int, 10: VARCHAR(45),
//11: VARCHAR(35), 12: VARCHAR(85), 13: int, 14: int, 15: int,
//16: double, 17: double, 18: VARCHAR(35)

public class Record {
	private int census_yr;
	private int block_id;
	private int prop_id;
	private int base_prop_id;
	private char[] building_name = new char[70];
	private char[] street_address = new char[40];
	private char[] suburb = new char[35];
	private int construct_yr;
	private int refurbished_yr;
	private int num_floors;
	private char[] space_usage = new char[45];
	private char[] access_type = new char[35];
	private char[] access_desc = new char[85];
	private int access_rating;
	private int bicycle_spaces;
	private int has_showers;
	private double x_coor;
	private double y_coor;
	private char[] location = new char[35];
	
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
		this.setBuilding_name(building_name);
		this.setStreet_address(street_address);
		this.setSuburb(suburb);
		this.construct_yr = construct_yr;
		this.refurbished_yr = refurbished_yr;
		this.num_floors = num_floors;
		this.setSpace_usage(space_usage);
		this.setAccess_type(access_type);
		this.setAccess_desc(access_desc);
		this.access_rating = access_rating;
		this.bicycle_spaces = bicycle_spaces;
		this.has_showers = has_showers;
		this.x_coor = x_coor;
		this.y_coor = y_coor;
		this.setLocation(location);		
	}
	
	public void record_display() {
		System.out.println("Census Year: "+this.getCensus_yr());
		System.out.println("Block ID: "+this.getBlock_id());
		System.out.println("Property ID: "+this.getProp_id());
		System.out.println("Base Property ID: "+this.getBase_prop_id());
		this.display_char_array(this.getBuilding_name(), "Building Name: ");
		this.display_char_array(this.getStreet_address(), "Street Address: ");
		this.display_char_array(this.getSuburb(), "Suburb: ");
		System.out.println("Construction Year: "+this.getConstruct_yr());
		System.out.println("Refurbished Year: "+this.getRefurbished_yr());
		System.out.println("Number of Floors: "+this.getNum_floors());
		this.display_char_array(this.getSpace_usage(), "Space Usage: ");
		this.display_char_array(this.getAccess_type(), "Access Type: ");
		this.display_char_array(this.getAccess_desc(), "Access Description: ");
		System.out.println("Access Rating: "+this.getAccess_rating());
		System.out.println("X Coordinate: "+this.getX_coor());
		System.out.println("Y Coordinate: "+this.getY_coor());
		this.display_char_array(this.getLocation(), "Location: ");		
	}
	
	// Method to Display the Character Array
	public void display_char_array(char[] str, String display) {
		System.out.print(display);
		for(int i=0; i<str.length; i++) {
			//if(str[i] != '#') {
				System.out.print(str[i]);	
			//} else {
			//	break;
			//}
		}
		System.out.println();
	}
	
	// GETTERS
	public int getCensus_yr() {
		return census_yr;
	}
	public int getBlock_id() {
		return block_id;
	}
	public int getProp_id() {
		return prop_id;
	}
	public int getBase_prop_id() {
		return base_prop_id;
	}
	public char[] getBuilding_name() {
		return building_name;
	}
	public char[] getStreet_address() {
		return street_address;
	}
	public char[] getSuburb() {
		return suburb;
	}
	public int getConstruct_yr() {
		return construct_yr;
	}
	public int getRefurbished_yr() {
		return refurbished_yr;
	}
	public int getNum_floors() {
		return num_floors;
	}
	public char[] getSpace_usage() {
		return space_usage;
	}
	public char[] getAccess_type() {
		return access_type;
	}
	public char[] getAccess_desc() {
		return access_desc;
	}
	public int getAccess_rating() {
		return access_rating;
	}
	public int getBicycle_spaces() {
		return bicycle_spaces;
	}
	public int getHas_showers() {
		return has_showers;
	}
	public double getX_coor() {
		return x_coor;
	}
	public double getY_coor() {
		return y_coor;
	}
	public char[] getLocation() {
		return location;
	}

	
	
	// SETTERS
	public void setCensus_yr(int census_yr) {
		this.census_yr = census_yr;
	}
	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}
	public void setProp_id(int prop_id) {
		this.prop_id = prop_id;
	}
	public void setBase_prop_id(int base_prop_id) {
		this.base_prop_id = base_prop_id;
	}
	public void setBuilding_name(String building_name) {
		HMethods hm = new HMethods();
		this.building_name = hm.char_fill(building_name, 70);
	}
	public void setStreet_address(String street_address) {
		HMethods hm = new HMethods();
		this.street_address = hm.char_fill(street_address, 40);
	}
	public void setSuburb(String suburb) {
		HMethods hm = new HMethods();
		this.suburb = hm.char_fill(suburb, 35);
	}
	public void setConstruct_yr(int construct_yr) {
		this.construct_yr = construct_yr;
	}
	public void setRefurbished_yr(int refurbished_yr) {
		this.refurbished_yr = refurbished_yr;
	}
	public void setNum_floors(int num_floors) {
		this.num_floors = num_floors;
	}
	public void setSpace_usage(String space_usage) {
		HMethods hm = new HMethods();
		this.space_usage = hm.char_fill(space_usage, 45);
	}
	public void setAccess_type(String access_type) {
		HMethods hm = new HMethods();
		this.access_type = hm.char_fill(access_type, 35);
	}
	public void setAccess_desc(String access_desc) {
		HMethods hm = new HMethods();
		this.access_desc = hm.char_fill(access_desc, 85);
	}
	public void setAccess_rating(int access_rating) {
		this.access_rating = access_rating;
	}
	public void setBicycle_spaces(int bicycle_spaces) {
		this.bicycle_spaces = bicycle_spaces;
	}
	public void setHas_showers(int has_showers) {
		this.has_showers = has_showers;
	}
	public void setX_coor(double x_coor) {
		this.x_coor = x_coor;
	}
	public void setY_coor(double y_coor) {
		this.y_coor = y_coor;
	}
	public void setLocation(String location) {
		HMethods hm = new HMethods();
		this.location = hm.char_fill(location, 35);
	}
	
	
}
