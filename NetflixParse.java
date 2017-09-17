package netflixparser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.io.FileWriter;


public class NetflixParse {
	public static void main(String[] args)throws IOException {
		//create and show the window
		String memberNumber="",newLine="";
		File fout = new File("src/netflixparser/out1.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		try {
			//try and open the file
			File f = new File("src/netflixparser/combined_data_1.txt");
			
			Scanner scanner = new Scanner(f);
			//read through the file and load each line into a song object and array
			
			while (scanner.hasNextLine()){
				String line = scanner.nextLine();
				int colon = line.indexOf(":");
				if (colon != -1) {
					memberNumber = line.substring(0 , colon);
				} else {
					newLine = memberNumber +","+ line;
					System.out.println(newLine);
					bw.write(newLine);
					bw.newLine();
				}
				
			}
			//for(SongRecord s : songs){
			//	System.out.println(s.getRank());
			//}
			scanner.close();
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
}
