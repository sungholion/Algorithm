import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x;
	int y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0 , -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int cnt_normal = 0;
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs_nomal(new Point(i, j));
					cnt_normal++;
				}
			}
		}
		
		int cnt_red_green = 0;
		visited = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j]) {
					bfs_red_green(new Point(i, j));
					cnt_red_green++;
				}
			}
		}
		
		sb.append(cnt_normal + " " + cnt_red_green);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs_nomal(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visited[start.x][start.y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(!rangeCheck(nx, ny)) continue;
				
				if(map[cur.x][cur.y] == map[nx][ny]) {	// 색깔 같으면
					q.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
				
				
			}
		}
	}
	
	static void bfs_red_green(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visited[start.x][start.y] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			char cur_c = map[cur.x][cur.y];
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(!rangeCheck(nx, ny)) continue;
				
				if(cur_c == 'R') {
					if(map[nx][ny] == 'R' || map[nx][ny] == 'G') {
						q.offer(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
				
				else if(cur_c == 'G') {
					if(map[nx][ny] == 'G' || map[nx][ny] == 'R') {
						q.offer(new Point(nx, ny));
						visited[nx][ny] = true;	
					}
				}
				
				else if(cur_c == 'B') {
					if(map[nx][ny] == cur_c) {
						q.offer(new Point(nx, ny));
						visited[nx][ny] = true;
					}
				}
				
			
				
			}
		}
	}

	static boolean rangeCheck(int x, int y) {
		if(x >=0 && y >=0 && x < n && y < n && !visited[x][y])
			return true;
		return false;
	}
}
