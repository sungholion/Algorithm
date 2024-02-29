import java.io.BufferedReader;
import java.io.FileInputStream;
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
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(L == 1) 
				System.out.println("#" + TC + " " + 1);
			else {
				bfs(new Coord(R, C, map[R][C]));
				System.out.println("#" + TC + " " + totalCnt);
			}
			
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
			if(visited[cx][cy]-1 ==  L) break;	// 제한 초
			else totalCnt++;
			
//			System.out.print(cx + " " + cy + " -> ");
			for(int i=0; i<4; i++) {
				int nx = cx + dirx[cType][i];
				int ny = cy + diry[cType][i];
				
				if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny]!= 0 && visited[nx][ny] == 0) {
					 // 서로 연결될 수 있는 파이프 유형인지!!!!!
						Coord next = new Coord(nx, ny, map[nx][ny]);
						if(isConnected(cur, next, i)) {
							q.offer(next);
							visited[nx][ny] = visited[cx][cy] + 1;
							
						}
				}
			}
			
		}
		
		
		return;
	}
	
	static boolean isConnected(Coord cur, Coord cur_next, int direction) {
		int cx = cur.x;
		int cy = cur.y;
		int cType = cur.type;
		int nx = cur_next.x;
		int ny = cur_next.y;
		int next = cur_next.type;
		int cnt = 0;
		
		if(cType == 1) {
			 if (direction == 0) {
	                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
	            }
	            if (direction == 1) {
	                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
	            }
	            if (direction == 2) {
	                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
	            }
	            if (direction == 3) {
	                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
	            }
		}
		else if(cType == 2) {
			 if (direction == 0) {
	                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
	            }
	            if (direction == 1) {
	                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
	            }
		}
		else if(cType == 3) {
			if (direction == 2) {
                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
            }
            if (direction == 3) {
                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
            }
		}
		else if(cType == 4) {
			  if (direction == 0) {
	                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
	            }
	            if (direction == 3) {
	                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
	            }
		}
		else if(cType == 5) {
			if (direction == 3) {
                if (next == 1 || next == 3 || next == 6 || next == 7) return true;
            }
            if (direction == 1) {
                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
            }
		}
		else if(cType == 6) {
			 if (direction == 2) {
	                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
	            }
	            if (direction == 1) {
	                if (next == 1 || next == 4 || next == 7 || next == 2) return true;
	            }
		}
		else if(cType == 7) {
			  if (direction == 0) {
	                if (next == 1 || next == 2 || next == 5 || next == 6) return true;
	            }
	            if (direction == 2) {
	                if (next == 1 || next == 3 || next == 4 || next == 5) return true;
	            }
	        }
		
		return false;
//		if(dirx[cType][0] == -dirx[nType][1] ||
//			dirx[cType][1] == -dirx[nType][0] ||
//			diry[cType][2] == -diry[nType][3] ||
//			diry[cType][3] == -diry[nType][2]
//			) {
//			return true;
//		}
//		
//		return false;
		
//		for(int i=0; i<4; i++) {
//			if(dirx[cType][i] == -dirx[nType][i] || diry[cType][i] == -diry[nType][i]) {
//				return true;
//			}
//		}
//		
//		return false;
		
//		for(int i=0; i<4; i++) {
//			int dr = nx + dirx[nType][i];
//			int dc = ny + diry[nType][i];
//			if(dr >= 0 && dc >= 0 && dr < N && dc < M && map[dr][dc] == map[cx][cy]) {
//				cnt++;
//				break;
//			}
//		}
		
//		if(cnt == 2) return true;
//		else return false;
//		
	}


}		
