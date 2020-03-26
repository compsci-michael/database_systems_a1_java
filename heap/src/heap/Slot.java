package heap;

public class Slot {
	Record record;
	
	public Slot(Record record) {
		this.record = record;
	}

	// Getters
	public Record get_record() {
		return record;
	}

	// Setters
	public void set_record(Record record) {
		this.record = record;
	}
	
}
