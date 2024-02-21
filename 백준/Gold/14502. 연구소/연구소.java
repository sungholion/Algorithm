// boj 14502 연구소
// 시간제한 2초 메모리 512MB

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};	// 상하좌우
	static int[] dy = {0, 0, -1, 1};
	static int wallCnt = 3;	// 세울 수 있는 벽의 개수 (3개 모두 사용해야 함)
	static int safeZone = Integer.MIN_VALUE;	// 안전 구역의 최댓값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());	// 행
		M = Integer.parseInt(st.nextToken());	// 열
		map = new int[N+1][M+1];	// 0은 빈 칸, 1은 벽, 2는 바이러스(2~10개)
		
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);	// 벽 3개를 세우는 모든 경우의 수
		
		bw.write(safeZone + "");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void dfs(int depth) {
		if(depth == wallCnt) {	// 벽 3개를 다 세우면
			bfs();	// 바이러스 퍼트리기
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(map[i][j] == 0) {	// 빈 칸인 경우
					map[i][j] = 1;	// 벽세우기
					dfs(depth + 1);	// 다음 벽 세우러 가기
					map[i][j] = 0;	// 이번 위치에 벽 안세우기
				}
			}
		}
		
	}

	static void bfs() {
		int[][] pollution = new int[N+1][M+1];	// 오염시키기 위해 새 배열 복사
		Queue<Coord> q = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				pollution[i][j] = map[i][j];
			}
		}
		
		for(int i = 1; i <= N; i++) {	// 바이러스가 있는 곳일 경우 큐에 추가
			for(int j = 1; j <= M; j++) {
				if(pollution[i][j] == 2) {
					q.add(new Coord(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {	
			Coord cur = q.poll();	// 바이러스가 있는 위치를 가져옴
			
			for(int i=0; i<4; i++) {	// 상하좌우로 퍼뜨리기
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx >=1 && nx <= N && ny >=1 && ny <= M) {
					if(pollution[nx][ny] == 0) {
						pollution[nx][ny] = 2;
						q.add(new Coord(nx,ny));
					}
				}
			}
		}
		
		getSafeZone(pollution);	// 안전구역 구하기
		
		
	}
	
	static void getSafeZone(int[][] cur_pollution) {
		int tmp = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=M; j++) {
				if(cur_pollution[i][j] == 0) tmp++;
			}
		}
		
		safeZone = Math.max(tmp, safeZone);
	}
}

