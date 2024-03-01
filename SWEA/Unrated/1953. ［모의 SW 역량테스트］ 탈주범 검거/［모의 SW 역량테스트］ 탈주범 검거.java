import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord{
	int x;
	int y;
	int type;
	
	public Coord(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
}

public class Solution {
	static int N, M, R, C, L; // 지도의 세로, 가로 / 맨홀의 세로, 가로 / 소요된 시간
	static int[][] map;
	static int[][] visited;
	static int[][] dirx= {
						{0, 0, 0, 0},
						{-1, 1, 0, 0},	// 1. 상하좌우
						{-1, 1, 0, 0},	// 2. 상하
						{0, 0, 0, 0},	// 3. 좌우
						{-1, 0, 0, 0},	// 4. 상우
						{0, 1, 0, 0},	// 5. 하우
						{0, 1, 0, 0},	// 6. 하좌
						{-1, 0, 0, 0}	// 7. 상좌
						};
	
	static int[][] diry = {
						{0, 0, 0, 0},
						{0, 0, -1, 1}, // 1. 상하좌우
						{0, 0, 0, 0},	// 2. 상하
						{0, 0, -1, 1},	// 3. 좌우
						{0, 0, 0, 1},	// 4. 상우
						{0, 0, 0, 1},	// 5. 하우
						{0, 0, -1, 0}, // 6. 하좌
						{0, 0, -1, 0}	// 7. 상좌
						};
	
	static int totalCnt;	// 장소의 총 개수
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("src/input.txt"));	// input 파일 자동 입력. 제출시 주석 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int TC=1; TC<=T; TC++) {
			// 입력
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new int[N][M];
			totalCnt = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M; j++) 
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			if(L == 1) 
				totalCnt = 1;
			else 
				bfs(new Coord(R, C, map[R][C]));
			
			System.out.println("#" + TC + " " + totalCnt);
		}
	}
	
	static void bfs(Coord start) {
		Queue<Coord> q = new LinkedList<>();
		q.offer(start);
		visited[start.x][start.y] = 1;
		
		while(!q.isEmpty()) {
			Coord cur = q.poll();
			int cx = cur.x;
			int cy = cur.y;
			int cType = cur.type;	
			if(visited[cx][cy] - 1 ==  L) break;	// 제한 초. 시작이 1초이기 때문에 -1 
			else totalCnt++;
			
			for(int i=0; i<4; i++) {
				int nx = cx + dirx[cType][i];	// 현재 있는 칸의 구조물이 갈 수 있는 좌표를 구함.
				int ny = cy + diry[cType][i];
				
				// 다음 좌표가 맵을 벗어나지 않는지, 갈 수 있는 칸인지(구조물 있어야 함), 방문한 적 던 곳인지 체크
				if(nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny]== 0 || visited[nx][ny] != 0)
					continue;
				
				// 다음 구조물과 연결되는지 확인하고, 연결되 있다면 큐에 넣음.
				Coord nType = new Coord(nx, ny, map[nx][ny]);	
				if(isConnected(cur, nType, i)) {		
					q.offer(nType);	
					visited[nx][ny] = visited[cx][cy] + 1;	// 연결되어 있는 칸들 거리 + 1 (1초마다 갈 수 있는 거리 갱신)
				}
			}
		}
		
		return;
	}
	
	static boolean isConnected(Coord cur, Coord cur_nType, int direction) {
		int cType = cur.type;
		int nType = cur_nType.type;
		
		if(cType == 1) {
			 if (direction == 0) 
	                if (nType == 1 || nType == 2 || nType == 5 || nType == 6) return true;
	         if (direction == 1) 
	                if (nType == 1 || nType == 4 || nType == 7 || nType == 2) return true;
	         if (direction == 2) 
	                if (nType == 1 || nType == 3 || nType == 4 || nType == 5) return true;
	         if (direction == 3) 
	                if (nType == 1 || nType == 3 || nType == 6 || nType == 7) return true;
		}
		else if(cType == 2) {
			 if (direction == 0) 
	                if (nType == 1 || nType == 2 || nType == 5 || nType == 6) return true;
	         if (direction == 1) 
	                if (nType == 1 || nType == 4 || nType == 7 || nType == 2) return true;
		}
		else if(cType == 3) {
			if (direction == 2) 
                	if (nType == 1 || nType == 3 || nType == 4 || nType == 5) return true;
            if (direction == 3) 
                	if (nType == 1 || nType == 3 || nType == 6 || nType == 7) return true;
		}
		else if(cType == 4) {
			if (direction == 0) 
	                if (nType == 1 || nType == 2 || nType == 5 || nType == 6) return true;
	        if (direction == 3) 
	                if (nType == 1 || nType == 3 || nType == 6 || nType == 7) return true;
		}
		else if(cType == 5) {
			if (direction == 3) 
                	if (nType == 1 || nType == 3 || nType == 6 || nType == 7) return true;
            if (direction == 1) 
                	if (nType == 1 || nType == 4 || nType == 7 || nType == 2) return true;
		}
		else if(cType == 6) {
			if (direction == 2) 
	                if (nType == 1 || nType == 3 || nType == 4 || nType == 5) return true;
	        if (direction == 1) 
	                if (nType == 1 || nType == 4 || nType == 7 || nType == 2) return true;
		}
		else if(cType == 7) {
			if (direction == 0) 
	                if (nType == 1 || nType == 2 || nType == 5 || nType == 6) return true;
	        if (direction == 2) 
	                if (nType == 1 || nType == 3 || nType == 4 || nType == 5) return true;
	        }
		
		return false;
	}
}		
