import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;	// 전체 맵
	static boolean[][] visited;	// 방문 배열
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};	// 12시부터 시계 방향으로 8방면
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	static boolean isBong;	// 봉우리인지 확인 (flag 역할)
	static int bongCnt = 0;	// 봉우리 갯수(answer)
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//------------------------------------------------------입력 끝
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {	// 방문하지 않은 지점에 대하여
					isBong = true;
					dfs(i, j);			// 연결된 지점 dfs
					if(isBong)			// 근처에 더 높은 지점이 없다면
						bongCnt++;		// 봉우리 개수 +1
				}
			}
		}
		
		bw.write(bongCnt + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int x, int y) {
		for(int i=0; i<8; i++) {	// 현재 지점에 대해 8방면 확인
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!rangeCheck(nx, ny))	// 지도 벗어나는지 체크
				continue;
			
			if(map[x][y] < map[nx][ny]) {	// 현재 지점보다 높은 지점이 있으면, 봉우리가 아님.
				isBong = false;
			}
			
			else if(map[x][y] == map[nx][ny] && !visited[nx][ny]) {	// 현재 지점과 같은 높이 지점이 있다면(+방문하지 않았다면)
				visited[nx][ny] = true;	// 방문처리 (하나의 지점으로 보니까)
				dfs(nx, ny);	// 연결된 지점 dfs
			}
		}
		
		return;
	}
	
	static boolean rangeCheck(int x, int y) {
		if(x >=0 && y>=0 && x < n && y < m )
			return true;
		return false;
	}
	
}
