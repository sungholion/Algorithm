import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static Stack<int[]> s = new Stack<>();
	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<=n; i++) {
			int top = Integer.parseInt(st.nextToken());
			while(!s.isEmpty()) {
				if(s.peek()[1] < top) s.pop();
				else {
					bw.write(s.peek()[0] + " ");
					break;
				}
			}
			if(s.isEmpty()) 
				bw.write("0 ");
			s.push(new int[] {i, top});
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
