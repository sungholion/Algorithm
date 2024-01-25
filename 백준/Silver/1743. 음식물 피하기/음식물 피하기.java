import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m, n, k, cnt;
	static int[][] g;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visited;
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		cnt++;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
		
		if(nx>=0 && ny>=0 && nx < n+1 && ny < m+1) {
			if(g[nx][ny] == 1 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
}
	
	
	public static void main(String[] args) throws IOException{
	 			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				StringTokenizer st = new StringTokenizer(br.readLine());
		 		n = Integer.parseInt(st.nextToken()); // 세로
		 		m = Integer.parseInt(st.nextToken()); // 가로
				k = Integer.parseInt(st.nextToken()); // 음식물 개수
				
				g = new int[n+1][m+1];
				visited = new boolean[n+1][m+1];
				
				for(int i=0; i<k; i++) {
					st = new StringTokenizer(br.readLine());
					int r = Integer.parseInt(st.nextToken());
					int c = Integer.parseInt(st.nextToken());
					g[r][c] = 1;
				}
				
				
				int ans = 0;
				for(int i=1; i<n+1; i++) {
					for(int j=1; j<m+1; j++) {
						if (g[i][j] == 1 && !visited[i][j]) {
							cnt = 0;
							dfs(i, j);
							ans = Math.max(ans, cnt);
						}
					}
		 
				}
				System.out.println(ans);
				} 
	}





