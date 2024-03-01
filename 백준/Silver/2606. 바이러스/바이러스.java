import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;	// 컴퓨터 수, 연결 쌍 수
	static int[][] map;
	static boolean[]visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int com1 = Integer.parseInt(st.nextToken());
			int com2 = Integer.parseInt(st.nextToken());
			map[com1][com2] = map[com2][com1] = 1;
		}
		
		bfs(1);
		
		sb.append(cnt);
		System.out.println(sb.toString());
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=1; i<=n; i++) {
				if(map[cur][i] == 1 && visited[i] == false) {
					q.offer(i);
					visited[i] = true;
					cnt++;
				}
			}
			
		}
		
	
	}
	
}
