import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	static int cnt;
	static List<Integer> ans;
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(range_check(nx, ny)) {
				cnt++;
				dfs(nx, ny);
			}
		}
	}
	
	public static boolean range_check(int x, int y) {
		if(x>=0 && y>=0 && x<n && y<n && !visited[x][y] && map[x][y] == 1)
			return true;
		else return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new boolean[n][n];
		ans = new LinkedList<>();
		
		for(int i=0; i<n; i++){
			String input = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		cnt = 1; // 첫 집도 세아림
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					dfs(i, j);
					ans.add(cnt);
					cnt = 1;
				}
			}
		}
		
		Collections.sort(ans);
		bw.write(ans.size() + "\n");
		for(int a : ans)
			bw.write(a + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
	
}