import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;


public class Parse {
	void tokenize(String filename){
		System.out.println(filename);
		
		try {
			String line;
			System.out.println("reached here");
			BufferedReader bf=new BufferedReader(new FileReader(filename));
			
			while ((line = bf.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
