import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); // 명령어 수
		Stack<Integer> s = new Stack<>();
		
		for(int tc=0; tc<n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String ord = st.nextToken();
			if(ord.equals("push")) {
				int x = Integer.parseInt(st.nextToken());
				s.add(x);
			}
			else if(ord.equals("pop")) {
				if(!s.isEmpty())
					System.out.println(s.pop());
				else
					System.out.println(-1);
			}
			else if(ord.equals("size")) {
				System.out.println(s.size());
			}
			else if(ord.equals("empty")) {
				if(s.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(ord.equals("top")) {
				if(!s.isEmpty())
					System.out.println(s.peek());
				else
					System.out.println(-1);
			}
				
			
			
		}
	}	
}