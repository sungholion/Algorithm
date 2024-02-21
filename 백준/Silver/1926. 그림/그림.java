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
	static int[][] paint;
	static boolean[][] visited;
	static int cntPaint;
	static int maxArea;
	static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		paint = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				paint[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(paint[i][j] == 1 && !visited[i][j]) {
					bfs(new Coord(i,j));
					cntPaint++;
				}
				
			}
		}
		
		bw.write(cntPaint + "\n" + maxArea);
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void bfs(Coord start) {
		Queue<Coord> q = new ArrayDeque<>();
		
		visited[start.x][start.y] = true;
		q.offer(start);
		
		int tempArea = 1; // 시작점 포함
		while(!q.isEmpty()) {
			Coord cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >=0 && ny>=0 && nx < n && ny < m && !visited[nx][ny] && paint[nx][ny] == 1) {
					Coord next = new Coord(nx,ny);
					visited[next.x][next.y] = true;
					q.offer(next);
					tempArea++;
				}
			}
		}
		
		if(tempArea > maxArea)
			maxArea = tempArea;
		
		return;
	}
}
