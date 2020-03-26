package heap;

public class Page {
	int number_of_records_in_page;
	boolean page_is_full;
	int page_size;
	
	public Page(int page_size) {
		this.number_of_records_in_page = 0;
		this.page_is_full = false;
		this.page_size = page_size;
	}
	
	
}
