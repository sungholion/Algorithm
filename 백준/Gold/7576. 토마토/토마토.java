import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
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

public class Main{
	static int n, m;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Coord> q = new LinkedList<>();
	static int tomato_cnt;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		int isZero = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.offer(new Coord(i, j));
				}
				if(map[i][j] == 0) {
					isZero++;
				}
			}
		}
		
		if(isZero == 0) System.out.println(0);
		
		else {
			bfs();
		}
			
	}
	
	static void bfs() {
		while(!q.isEmpty()) {
			Coord cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >=0 && nx<n && ny >=0 && ny < m && map[nx][ny] == 0) {
					q.offer(new Coord(nx, ny));
					map[nx][ny] = map[cur.x][cur.y] + 1;
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				if(map[i][j] > max) max = map[i][j];
			}
		}
		
		System.out.println(max-1);
		return;
		
	}
	
}