package DataTransferObjectGA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class demo {
	final int T = 100;
	final int R = 200;
	
	public static void main (String args[]) {
		testReadLine();
//		ArrayList< ArrayList<Integer> > adj_f = new ArrayList<ArrayList<Integer>>();
//		for(int i=0 ; i < 10; i++) {
//			ArrayList<Integer> n = new ArrayList<>();
//			n.add(4); n.add(4);
//			
//			adj_f.add(n);
//		}
//		for(int i = 0; i < adj_f.size(); i ++) {
//			for(int j = 0; j < adj_f.get(i).size(); j++) {
//				System.out.print(adj_f.get(i).get(j));
//			}
//		}
//		
	}
	public static void testReadLine() {
		
		try {
			String fileName = "src/data/data.txt";
			File file = new File(fileName);
			FileReader fr;
			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			int countLine =0;
			while((line = br.readLine()) != null){
			    //process the line
			    System.out.println(line);
				countLine++;
			    
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
