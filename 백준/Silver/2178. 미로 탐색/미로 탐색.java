import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord{
	int x;
	int y;
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m;
	static int[][] maze;
	static int[][] visited;
	static int minGo;
	static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maze = new int[n+1][m+1];
		visited = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			String input = br.readLine();
			for(int j=1; j<=m; j++) {
				maze[i][j] = input.charAt(j-1) - '0';
			}
		}
		
		bfs(new Coord(1, 1));
		
		bw.write(visited[n][m] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void bfs(Coord start) {
		Queue<Coord> q = new ArrayDeque<>();
		
		visited[start.x][start.y] = 1;
		q.offer(start);
		
		while(!q.isEmpty()) {
			Coord cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >=1 && ny>=1 && nx <= n && ny <= m && visited[nx][ny] == 0 && maze[nx][ny] != 0) {
					Coord next = new Coord(nx,ny);
					visited[next.x][next.y] = visited[cur.x][cur.y] + 1;
					q.offer(next);
				}
			}
		}
		
		
		return;
	}
}
