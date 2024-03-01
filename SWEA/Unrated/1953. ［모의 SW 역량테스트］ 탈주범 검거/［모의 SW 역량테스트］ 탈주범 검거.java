import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tunnel{	// 터널 정보를 저장하기 위한 클래스
	int x;	// 구조물 세로 좌표
	int y;	// 구조물 가로 좌표
	int t;	// 구조물 타입
	
	public Tunnel(int x, int y, int t) {
		this.x = x;
		this.y = y;
		this.t = t;
	}
}

public class Solution {
	static int N, M;							// 지하 터널 지도의 세로 크기, 가로 크기
	static int R, C;							// 맨홀 뚜껑이 위치한 장소의 세로 위치, 가로 위치
	static int L;								// 탈출 후 소요된 시간 (맨홀에 들어가는 시간도 1초 소요)
	static int[][] map;							// 지하 터널의 정보(0 : 터널 없음, 1~7 :구조물 타입)
	static int[][] visited;						// 탈주범의 터널 방문 여부 및 거리(시간) 표시를 위한 배열
	static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int ans;		// 정답 : 탈주범이 있을 수 있는 장소의 개수
	
	public static void main(String[] args) throws IOException{
		//System.setIn(new FileInputStream("src/swea_1953_input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());	// 테스트 케이스 수
		for(int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 5 <= N, M <= 50
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());	// 0 <= R <= N-1
			C = Integer.parseInt(st.nextToken());	// 0 <= C <= M-1
			L = Integer.parseInt(st.nextToken());	// 1 <= L <= 20
			
			map = new int[N][M];
			visited = new int[N][M];
			ans = 0;	// 테스트 케이스마다 정답 초기화
			
			for(int i = 0; i < N; i++) {	// 입력
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(L == 1) ans = 1;	// 1초 밖에 주어지지 않으면, 갈 수 있는 곳은 시작점 1개뿐.
			else
				bfs(new Tunnel(R, C, map[R][C]));	// 탈주범이 들어간 맨홀의 위치와 터널 구조물 타입 정보
			
			sb.append("#" + tc + " " + ans + "\n");
		}
		System.out.println(sb.toString());
	}
	
	static void bfs(Tunnel criminal) {
		Queue<Tunnel> q = new LinkedList<>();
		q.offer(criminal);
		visited[criminal.x][criminal.y] = 1;	// 맨홀에 도착하는 순간도 1초로 세아림.
		
		while(!q.isEmpty()) {
			Tunnel cur = q.poll();	
			if(visited[cur.x][cur.y] - 1 == L) break;	// 제한 시간과 같은 시간만큼 걸리는 거리라면 멈추기. (시작점이 1이라 -1)
			else ans++;	// 갈 수 있는 경우의 수 누적
			
			for(int i = 0; i < 4; i++) {		// 상하좌우 탐색
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(!rangeCheck(nx, ny)) continue;	// 좌표가 조건에 부합하지 않으면 탐색하지 않음.
				
				Tunnel next = new Tunnel(nx, ny, map[nx][ny]);	// 다음 구조물 정보
				
				if(!isConnected(cur, next, i)) continue;	//	현재 구조물과 다음 구조물이 연결되지 않으면 탐색하지 않음.
				
				q.offer(next);	// 범위 조건을 만족하고, 현재 구조물과 연결되어 있다면 다음 구조물도 큐에 넣기.
				visited[next.x][next.y] = visited[cur.x][cur.y] + 1;	// 현재 구조물에서 갈 수 있는 칸들에 걸리는 시간을 누적해서 저장.
			}
		}
	}
	
	static boolean rangeCheck(int x, int y) {
		// 좌표가 맵을 벗어나지 않고, 좌표에 구조물(터널)이 있고, 방문한 적 없는 좌표라면 true
		if(x >= 0 && x < N && y >= 0 && y < M && map[x][y] != 0 && visited[x][y] == 0)
			return true;
		return false;
	}
	
	static boolean isConnected(Tunnel cur, Tunnel next, int dir) {
		int ct = cur.t;
		int nt = next.t;
		
		// 구조물이 갈 수 있는 방향 중에서, 현재 바라보는 방향과 반대되는 방향을 다음 구조물이 가지고 있어야 연결.
		// ex) 4번 유형 구조물(상, 좌)이 dir = 0(상)일 때 위를 바라보고 있으므로, 다음 구조물은 '상'의 반대인 '하'를 포함하는 구조물이어야 함.
		if(ct == 1) {	// 현재 구조물이 1유형일 때
			if(dir == 0) {	// 위 방향을 탐색한다면
				if(nt == 1 || nt == 2 || nt == 5 || nt == 6) return true;	// 다음 구조물이 1, 2, 5, 6 유형일때 연결 O
			}
			if(dir == 1) {
				if(nt == 1 || nt == 2 || nt == 4 || nt == 7) return true;
			}
			if(dir == 2) {
				if(nt == 1 || nt == 3 || nt == 4 || nt == 5) return true;
			}
			if(dir == 3) {
				if(nt == 1 || nt == 3 || nt == 6 || nt == 7) return true;
			}
		}
		else if(ct == 2) {
			if(dir == 0) {	
				if(nt == 1 || nt == 2 || nt == 5 || nt == 6) return true;	
			}
			if(dir == 1) {
				if(nt == 1 || nt == 2 || nt == 4 || nt == 7) return true;
			}
		}
		else if(ct == 3) {
			if(dir == 2) {	
				if(nt == 1 || nt == 3 || nt == 4 || nt == 5) return true;	
			}
			if(dir == 3) {
				if(nt == 1 || nt == 3 || nt == 6 || nt == 7) return true;
			}
		}
		else if(ct == 4) {
			if(dir == 0) {	
				if(nt == 1 || nt == 2 || nt == 5 || nt == 6) return true;	
			}
			if(dir == 3) {
				if(nt == 1 || nt == 3 || nt == 6 || nt == 7) return true;
			}
		}
		else if(ct == 5) {
			if(dir == 1) {	
				if(nt == 1 || nt == 2 || nt == 4 || nt == 7) return true;	
			}
			if(dir == 3) {
				if(nt == 1 || nt == 3 || nt == 6 || nt == 7) return true;
			}
		}
		else if(ct == 6) {
			if(dir == 1) {	
				if(nt == 1 || nt == 2 || nt == 4 || nt == 7) return true;	
			}
			if(dir == 2) {
				if(nt == 1 || nt == 3 || nt == 4 || nt == 5) return true;
			}
		}
		else if(ct == 7) {
			if(dir == 0) {	
				if(nt == 1 || nt == 2 || nt == 5 || nt == 6) return true;	
			}
			if(dir == 2) {
				if(nt == 1 || nt == 3 || nt == 4 || nt == 5) return true;
			}
		}
		
		return false;
	}
}
