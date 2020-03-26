package heap;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

//Basic Maths of Records
// Fixed: Num of Records per Page = page_size/record_leng
// Variable: Use Counter
// Using Basic Maths, if Fixed, 48+70+40+35+45+35+85 = 358
// 4096/358 = 11 Records per Page
// It is known that there is 220,950 Records
// 220,950/11 = 20,087 Pages which is 220,950*358 = 79,100,100 Bytes
// However, space needs to be left at the end of the page so,
// 10 Records per Page = 220,950/10 = 22095 Pages => 22095*4096 = 90,501,120 Bytes

public class dbload {
	
	// Executable Name must be dbload
	// Must be able to execute the following: java dbload -p pagesize datafile
	public static void main(String[] args) {
		HMethods hm = new HMethods();
		int record_counter = 0;
		boolean data_read_failed = false;
		HashMap<String, Record> data = new HashMap<String, Record>();
		// Step 1: Validate the Input
		boolean correct_input = hm.input_validation(args);
		if(correct_input) {
			int page_size = hm.page_size(args);
			
			// Step 2: Read in the Data and Store in HashMap
			// Initialising an Input Stream
			Scanner input_stream = null;
			try {
				System.out.println("System - Loading File "+args[hm.DATA_FLAG]);
				input_stream = new Scanner(new FileReader(args[hm.DATA_FLAG]));
				// Removing Data Headers from File
				String[] data_headers = input_stream.nextLine().split(",");
				
				// Reading in data Line by Line
				while (input_stream.hasNextLine()) {
					// Splitting the Data Removing all Quotations
					String data_tmp = input_stream.nextLine().replaceAll("\"\"\"","");
					data_tmp = data_tmp.replaceAll("\"\"","");

					String[] data_unformatted = data_tmp.split("\"");
					int format_counter = 0;
					String[] data_formatted = new String[19];
					
					for(int i=0; i<data_unformatted.length; i++) {
						String temp = data_unformatted[i];
						// If we know that the data does contain a "," we will fast forward it
						if(data_unformatted[i].startsWith("Performance") || data_unformatted[i].charAt(0) == '(' 
								|| data_unformatted[i].startsWith("DEPARTMENT") || data_unformatted[i].startsWith("HOLDING")
								|| data_unformatted[i].startsWith("Lincoln") || data_unformatted[i].startsWith("Sussex")
								|| data_unformatted[i].startsWith("Mark Street") || data_unformatted[i].startsWith("Department")
								|| data_unformatted[i].startsWith("RMIT") || data_unformatted[i].startsWith("Marys")
								|| data_unformatted[i].startsWith("Melbourne")) {
							// Fixing Comma Error
							if(data_unformatted[i].charAt(0) != '(') {
								data_unformatted[i+1] = data_unformatted[i+1].substring(1);
							}
							data_formatted[format_counter++] = data_unformatted[i];
						} 
						// Fixing Issue with Special Case Number
						else if(data_unformatted[i].startsWith("1,800")) {
							temp = temp.replaceFirst(",", "");
							data_unformatted[i+1] = data_unformatted[i+1].substring(1);
							data_formatted[format_counter++] = temp;
						} else {
							String[] temp_arr = temp.split(",");
							for(int j=0; j<temp_arr.length;j++) {
								data_formatted[format_counter++] = temp_arr[j];
							}
						}
					}

					// NULL Checks for End Condition
					while(format_counter < 19) {
						data_formatted[format_counter++] = "";
					}
					
					for(int i=0; i<data_formatted.length; i++) {
						if(data_formatted[i].equals("")) {
							System.out.print("NULL$");
						} else {
							System.out.print(data_formatted[i]+"$");
						}
					}
					System.out.println();
					//Record new_record;
					
				}
				System.out.println("System - Loading File "+args[hm.DATA_FLAG]+" was Successful!");
			}
			// Catching IOException error
			catch (IOException e) {
				System.err.println("Error - Data Couldn't Be Extracted!");
				data_read_failed = true;				
			} 	
			// Closing input stream
			finally {
				if (input_stream != null)
					input_stream.close();
			}
			
			
			
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
