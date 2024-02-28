/*
bj_16236 아기 상어

문제
N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.
아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.
아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.
아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.

더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.

아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.
아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.
공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.
둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치
아기 상어는 공간에 한 마리 있다.

출력
첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.
 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Coord{
	int x;
	int y;
	int d;
	
	public Coord(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}
}

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n]; 
		Queue<Coord> q = new LinkedList<>();	// 다음 이동할 칸
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					q.add(new Coord(i, j, 0));	// 상어 추가
					map[i][j] = 0;
				}
			}
		}
		
		int big = 2;	// 상어 초기 사이즈
		int time = 0;	// 총 소요시간
		int eat = 0;	// 상어가 잡아먹은 수 
		
		while(true) {
			int[][] dis = new int[n][n];	// 거리 측정을 위한 새로운 맵
			List<Coord> fish = new ArrayList<>();	// 잡아먹을 수 있는 물고기 위치 리스트
			
			while(!q.isEmpty()) {
				Coord cur = q.poll();	// 큐에서 하나꺼내서(시작은 상어 위치)
				
				for(int i=0; i<4; i++) {
					int nx = cur.x + dx[i];	// 다음 좌표 계산
					int ny = cur.y + dy[i];
					
					// 다음 칸이 1. 맵을 벗어나지 않고, 2. 다음칸이 빈칸이거나 물고기라면 상어보다 작고 3. 방문하지 않은 곳이라면
					if(nx >=0 && ny >= 0 && nx < n && ny < n && map[nx][ny] <= big && dis[nx][ny] == 0) {
						dis[nx][ny] = dis[cur.x][cur.y] + 1;
						q.add(new Coord(nx, ny, dis[nx][ny]));
						// 만약에 이동한 칸에 물고기가 있는데, 상어보다 작다면
						if(map[nx][ny]!=0 && map[nx][ny] <=6 && map[nx][ny] < big) {
							fish.add(new Coord(nx, ny, dis[nx][ny]));
						}
					}
				}
			}
			
			if(fish.size() == 0) {	// 잡아먹을 수 있는 물고기 없으면 종료
				System.out.println(time);
				return;
			}
			
			Coord minFish = fish.get(0);
			for(int i=1; i<fish.size(); i++) {
				if(minFish.d > fish.get(i).d) {
					minFish = fish.get(i);
				}
				
				else if(minFish.d == fish.get(i).d) {
					if(minFish.x > fish.get(i).x) {
						minFish = fish.get(i);
					}
					else if(minFish.x == fish.get(i).x) {
						if(minFish.y > fish.get(i).y) {
							minFish = fish.get(i);
						}
					}
				}
			}
			
			time += minFish.d;
			eat++;
			map[minFish.x][minFish.y] = 0;
			if(eat == big) {
				big++;
				eat = 0;
			}
			
			q.add(new Coord(minFish.x, minFish.y, 0));
			
		}
		
	}
}
