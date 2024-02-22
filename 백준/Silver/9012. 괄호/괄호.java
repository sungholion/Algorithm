import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int loop=0; loop < tc; loop++) {
			String input = br.readLine();
			
			Stack<Character> s = new Stack<>();
			boolean pair = true;
			for(int i=0; i<input.length(); i++) {
				if(input.charAt(i) == '(') {
					s.push(input.charAt(i));
				}
				else if(input.charAt(i) == ')') {
					if(!s.isEmpty()) {
						if(s.pop()!= '(') {
							pair = false;
							break;
						}
						else continue;
					}
					else 
						pair = false;
					
				}
			}
			if(!s.isEmpty() || pair == false) {
				bw.write("NO\n");
			}
			else {
				bw.write("YES\n");
			}
			
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}