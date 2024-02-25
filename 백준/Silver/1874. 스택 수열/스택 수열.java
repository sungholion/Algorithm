import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	
	Stack<Integer> s = new Stack<>();
	
	int n = Integer.parseInt(br.readLine());
	
	int pos = 0;
	for(int loop=0; loop<n; loop++) {
		int x = Integer.parseInt(br.readLine());
		
		if(x > pos) {
			for(int i=pos+1; i<=x; i++) {
				s.push(i);
				sb.append("+").append("\n");
			}
			pos = x;
		}
		
		else if(s.peek()!= x) {
			System.out.println("NO");
			return;
		}
		
		s.pop();
		sb.append("-").append("\n");
		
	}
	
	System.out.println(sb.toString());
	
	}
}