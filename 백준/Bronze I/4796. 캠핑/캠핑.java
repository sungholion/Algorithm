import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = -1, P = -1, V = -1;
		int tc = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			if(L == 0 && P == 0 && V == 0) break;
			
			tc++;
			int cycle = V / P;
			int rem = V % P < L ? V%P : L;
			int result = L * cycle + rem;
			
			System.out.println("Case " + tc + ": " + result);
		}
	
	
	}
}