import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[][] g;
	static boolean[] visited;
	
	public static void dfs(int v) {
		if(visited[v] == true)
			return;
		
		else {
			visited[v] = true;
			for(int i=1; i<=n; i++) {
				if(g[v][i] == 1) {
					dfs(i);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
	 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			g = new int[n+1][n+1];
			visited = new boolean[n+1];
			
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				g[u][v] = g[v][u] = 1;
			}
			
			int ans = 0;
			
			for(int i=1; i<=n; i++) {
				if(visited[i] == false) {
					dfs(i);
					ans++;
				}
			}
			
			System.out.println(ans);
			
	}
}
