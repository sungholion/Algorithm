import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	static int l;
	static int x1, x2, y1, y2;
	static int cx, cy, nx, ny;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			l = Integer.parseInt(br.readLine());	// 변의 길이
			map = new int[l][l];
			visited = new boolean[l][l];
			
			st = new StringTokenizer(br.readLine());	// 시작점
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());	//도착점
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			bfs(x1, y1);
			
			System.out.println(map[x2][y2]);
		}
	}

	public static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			cx = cur[0];
			cy = cur[1];
			
			for(int i=0; i<dx.length; i++) {
				nx = cx + dx[i];
				ny = cy + dy[i];
				
				if(nx < 0 || ny < 0 || nx >=l || ny >= l || visited[nx][ny])
					continue;
				
				visited[nx][ny] = true;
				map[nx][ny] = map[cx][cy] + 1;
				q.add(new int[] {nx, ny});
			}
		}
	}
}
