import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		int m = Integer.parseInt(br.readLine());
		String op;
		int x;
		
		int S = 0;
		for(int t=0; t<m; t++) {
			st = new StringTokenizer(br.readLine());
			op = st.nextToken();
			if(!op.equals("all") && !op.equals("empty")){
				x = Integer.parseInt(st.nextToken());
				if(op.equals("add")) {
					S = S | (1 << x);
				}
				else if(op.equals("remove")) {
					S = S & ~(1 << x);
				}
				else if(op.equals("check")) {
					if(((1<<x)&S) > 0)
						bw.write("1\n");
					else
						bw.write("0\n");
				}
				else if(op.equals("toggle")) {
					if(((1<<x) & S) > 0)
						S = S & ~(1 << x);
					else
						S = S | (1 << x);
				}
			}
			else {
				if(op.equals("all")) {
					S = S | (1 << 21) - 1;
				}
				else if(op.equals("empty")) {
					S = 0;
				}
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}
	
}