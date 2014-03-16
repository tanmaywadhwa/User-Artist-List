import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class Initiate {
	public static void main(String[] Args){
		String InputFilename="Artist_lists_small.txt";
		String OutputFilename="Output.txt";
		String line;
		Map<Integer,Integer> list=new HashMap<Integer,Integer>();
		Map<String,Map> Tokens=new HashMap<String,Map>();
		try {
			BufferedReader bf=new BufferedReader(new FileReader(InputFilename));
			int i=1;
			while ((line = bf.readLine()) != null) {
				String[] tokensInLine=line.split(",");
				for(int j=0;j<tokensInLine.length;j++){
					if(Tokens.containsKey(tokensInLine[j])){
						Map<Integer, Integer> temp1=Tokens.get(tokensInLine[j]);
						Map<Integer, Integer> temp2=temp1;
						temp2.put(temp1.size()+1,i);
						Tokens.put(tokensInLine[j],temp2);	
					}
					else{
						Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
						temp.put(1, i);
						Tokens.put(tokensInLine[j],temp);
					}
				}
				i++;
			}
			bf.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//		Map<Integer,Integer> temp=new HashMap<Integer,Integer>();
		//		temp=Tokens.get("Avril Lavigne");
		//		System.out.println(temp.values());
		Set<String> check=Tokens.keySet();
		int totalCount=0;
		try {
			BufferedWriter bw=new BufferedWriter(new FileWriter(OutputFilename));
		for(String primary:check){
			if((Tokens.get(primary).size())>49){
				for(String secondary:check){
					if(!primary.equals(secondary)){
						Set<Integer> intersection=new HashSet<Integer>(Tokens.get(primary).values());
						intersection.retainAll(Tokens.get(secondary).values());
						if(intersection.size()>49){
							System.out.println(primary+" AND "+ secondary);
								bw.append(primary+" AND "+ secondary);
								bw.newLine();
							totalCount++;
						}
					}
				}
			}
		}
		bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n\n"+"The total number of tokens was :"+Tokens.size());
		System.out.println("The total number of qualifying candidates are: "+totalCount);
	}
}
