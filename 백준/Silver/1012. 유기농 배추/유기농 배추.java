import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int n;
	static int k;
	static int[][] g;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	static boolean[][] visited;
	static int cnt;
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
		
		if(nx>=0 && ny>=0 && nx < m && ny < n) {
			if(g[nx][ny] == 1 && !visited[nx][ny]) {
				dfs(nx, ny);
			}
		}
		}
		
	}
	
	
	public static void main(String[] args) throws IOException{
	 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());	//tc 입력
			
			for(int tc = 0; tc<t; tc++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
		 		m = Integer.parseInt(st.nextToken()); //가로
		 		n = Integer.parseInt(st.nextToken()); // 세로
				k = Integer.parseInt(st.nextToken());
				
				g = new int[m][n];
				visited = new boolean[m][n];
				
				for(int i=0; i<k; i++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					g[x][y] = 1;
				}
				
			
				cnt = 0;
				for(int i=0; i<m; i++) {
					for(int j=0; j<n; j++) {
						if (g[i][j] == 1 && !visited[i][j]) {
							dfs(i,j);
							cnt++;
						}
					}
		
				}
				System.out.println(cnt);
				} 
	}
}	