import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		
		while(str1.length() < str2.length()) {
			if(str2.charAt(str2.length()-1) == 'A') {
				str2 = str2.substring(0, str2.length()-1);
			}
			else if(str2.charAt(str2.length()-1) == 'B') {
				str2 = str2.substring(0, str2.length()-1);
				StringBuffer sb = new StringBuffer(str2);
				str2 = sb.reverse().toString();
			}
		}
		 
		if(str1.equals(str2)) bw.write("1");
		else bw.write("0");
		
		bw.flush();
		bw.close();
		br.close();
	}
}