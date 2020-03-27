///////////////////////////////////////////////////////////////////////////////
// File Written by: Michael A (s3662507) (Last Edit: 27/03/2020)
// Database Systems - Assignment 01
// Purpose of this Class:
// This is the Driver Class which contains the Main method for loading in a 
// Heap File and doing a Search Check on the "<search criteria" passed in the
// program arguements
///////////////////////////////////////////////////////////////////////////////
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
	
public class dbquery {	
	public static void main(String[] args) {
		// Set up Helper Methods
		HMethods hm = new HMethods();
		// Store the Page Size
		int page_size;
		// Number of Records For Debugging
		int num_of_records = 0;
		// Hash Map of Pages
		//HashMap<String, Page> page_data = new HashMap<String, Page>();
		String query = "";
		
		// Step 1: Validate the Input
		boolean correct_input = hm.input_validation_dbquery(args);
		if(correct_input) {
			page_size = hm.page_size(args);
			query = args[hm.SEARCH_CRITERIA];
			
			// Step 2: Reading in the Input from the File
			FileInputStream heap_file = null;
			BufferedInputStream heap_file_buffer = null;
			DataInputStream heap_file_reader = null;
			
			try {
				// Setting up File Operations
				System.out.println("System - Loading File heap."+page_size);
				heap_file = new FileInputStream(new File("heap."+Integer.toString(page_size)));
				heap_file_buffer = new BufferedInputStream(heap_file,page_size);
				heap_file_reader = new DataInputStream(heap_file_buffer);
				// This will store each Page being Read in
				byte[] page_data_temp = new byte[page_size];
				// A Counter for the Buffer of page_data_temp
				int buffer_counter = 0;
				// A Page Counter
				int page_number = 1;
				// Recording the Start Time
				final long query_start_time = System.nanoTime();

				// Go through the File and grab the page_size amount of Bytes
				while (heap_file_reader.read(page_data_temp) != -1) {
					//Page new_page = new Page(page_size);
					while((char)page_data_temp[buffer_counter] != '#') {
						// Make a New Record which is being Read in
						Record new_record = new Record();
						
						// Go Through the page_data_temp, block chunks at a time
						// and set the Record members
						new_record.set_census_yr(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_block_id(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_prop_id(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_base_prop_id(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_building_name(hm.byte_buffer_to_string(page_data_temp, buffer_counter, 63));
						buffer_counter+=63;
						new_record.set_street_address(hm.byte_buffer_to_string(page_data_temp, buffer_counter, 34));
						buffer_counter+=34;
						new_record.set_suburb(hm.byte_buffer_to_string(page_data_temp, buffer_counter, 28));
						buffer_counter+=28;
						new_record.set_construct_yr(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_refurbished_yr(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_num_floors(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_space_usage(hm.byte_buffer_to_string(page_data_temp, buffer_counter, 39));
						buffer_counter+=39;
						new_record.set_access_type(hm.byte_buffer_to_string(page_data_temp, buffer_counter, 32));
						buffer_counter+=32;
						new_record.set_access_desc(hm.byte_buffer_to_string(page_data_temp, buffer_counter, 81));
						buffer_counter+=81;
						new_record.set_access_rating(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_bicycle_spaces(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_has_showers(ByteBuffer.wrap(page_data_temp,buffer_counter,4).getInt());
						buffer_counter+=4;
						new_record.set_x_coor(ByteBuffer.wrap(page_data_temp,buffer_counter,8).getDouble());
						buffer_counter+=8;
						new_record.set_y_coor(ByteBuffer.wrap(page_data_temp,buffer_counter,8).getDouble());
						buffer_counter+=8;
						new_record.set_location(hm.byte_buffer_to_string(page_data_temp, buffer_counter, 27));
						buffer_counter+=27;
						
						if(new_record.contains(query)) {
							new_record.record_display();
						}
						
						/*
						// Set the Page's Slot to the new Record
						new_page.set_a_page_slot(new_record);
						// If the Page is full after this, push it to the page_data
						if(new_page.is_page_is_full()) {
							page_data.put(Integer.toString(page_number++),new_page);
							// And then Re-initialise for a New Page
							new_page = new Page(page_size);
						}
						*/
						// Keep track of number of Records
						num_of_records++;
					}
					// If we reached the end but the Page contained less than the
					// the Maximum limit, push that too into the page_data
					/*
					if(new_page != new Page(page_size)) {
						page_data.put(Integer.toString(page_number++),new_page);
					}
					*/
				// Resetting the Buffer Counter ready for the next Page
				buffer_counter = 0;
				// Reset the Buffer
				page_data_temp = new byte[page_size];
				}
				
				final long query_end_time = System.nanoTime();
				
				System.out.println("System - heap."+page_size+" was Successful Loaded!");
				
				//System.out.println("System - Number of Records Loaded: "+num_of_records);
				System.out.println("System - Time Taken to Read from Heap: "+ 
						(float)(query_end_time-query_start_time)/1000000000+" seconds");
				/*
				for (String key : page_data.keySet()) {
					//System.out.println("Page Number: "+page_counter_2++ +" Num Records: "+page_data.get(key).get_number_of_records_in_page());
					for(int i=0; i<page_data.get(key).number_of_records_in_page; i++) {
						page_data.get(key).get_page_slot_record(i).record_display_simple();
					}
				}
				*/
				
				// Close the Files
				heap_file_reader.close();
				heap_file_buffer.close();
				heap_file.close();
			}
			// Catching IOException error
			catch (IOException e) {
				System.err.println("Error - Data Couldn't Be Extracted!");				
			} 	
		}
	}	
}
