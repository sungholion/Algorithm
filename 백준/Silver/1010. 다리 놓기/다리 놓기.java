import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] table = new int[31][31];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int loop = 0; loop < T; loop++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			System.out.println(dfs(m, n));
		}
		
	}
	
	static int dfs(int m, int n) {
		if(table[m][n] > 0) {
			return table[m][n];
		}
		
		else if(m == n || n == 0) {
			return table[m][n] = 1;
		}
		else {
			return table[m][n] = dfs(m-1, n-1) + dfs(m-1, n);
		}
	}
	
}
