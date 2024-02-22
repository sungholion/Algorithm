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
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int maxHeight;
	static int maxSafeZone = 1;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > maxHeight) maxHeight = map[i][j];
			}
		}
		//---------------------------------------------------입력
		
		for(int rain=1; rain<=maxHeight; rain++) {
			visited = new boolean[N][N];
			int tmpSafeZone = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] > rain && !visited[i][j]) {
						tmpSafeZone++;
						bfs(new Coord(i,j), rain);
					}
				}
			}
			if(tmpSafeZone > maxSafeZone) maxSafeZone = tmpSafeZone;
		}
		
		
		bw.write(maxSafeZone + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(Coord start, int cur_rain) {
		Queue<Coord> q = new ArrayDeque<>();
		visited[start.x][start.y] = true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			Coord cur = q.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >=0 && ny >= 0 && nx < N && ny <N && !visited[nx][ny] && map[nx][ny] > cur_rain) {
					visited[nx][ny] = true;
					q.offer(new Coord(nx, ny));
				}
			}
		}
		
		return;
	}
	
}
