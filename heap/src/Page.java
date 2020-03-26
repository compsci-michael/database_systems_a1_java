public class Page {
	public static int MAX_RECORDS = 10;
	int number_of_records_in_page;
	boolean page_is_full;
	int page_size;
	Slot[] page_slots;
	
	public Page(int page_size) {
		this.number_of_records_in_page = 0;
		this.page_is_full = false;
		this.page_size = page_size;
		this.page_slots = new Slot[10];
	}

	// Getters
	public int get_number_of_records_in_page() {
		return number_of_records_in_page;
	}
	public boolean is_page_is_full() {
		return page_is_full;
	}
	public int get_page_size() {
		return page_size;
	}
	public Record get_page_slot_record(int slot_number) {
		return page_slots[slot_number].get_record();
	}
	
	// Setters
	public void set_page_size(int page_size) {
		this.page_size = page_size;
	}
	public void set_a_page_slot(Record record) {
		page_slots[number_of_records_in_page] = new Slot(record);
		number_of_records_in_page++;
		// Check if we are at the Limit
		if(number_of_records_in_page == MAX_RECORDS) {
			page_is_full = true;
		}
	}
	
	 @Override
     public boolean equals(Object o) {
         if (this == o) {
             return true;
         }
         if (o == null || getClass() != o.getClass()) {
             return false;
         }
         Page page = (Page) o;
         return page_slots == page.page_slots;
     }
}
