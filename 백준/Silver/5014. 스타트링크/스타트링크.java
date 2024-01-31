import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int F, S, G, U, D;
	static int[] building;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		F = Integer.parseInt(st.nextToken());	// 총 높이
		S = Integer.parseInt(st.nextToken());	// 현재 높이
		G = Integer.parseInt(st.nextToken());	// 목표 높이
		U = Integer.parseInt(st.nextToken());	// 위로 U층 이동
		D = Integer.parseInt(st.nextToken());	// 아래로 D층 이동
		
		building = new int[F+1];
		
		bfs(F, S, G);
	}
	
	public static void bfs(int max_h, int cur_h, int fin_h) {
		Queue<Integer> q = new LinkedList<>();
		q.add(cur_h);
		building[cur_h] = 1;
		
		while(!q.isEmpty()) {
			int now_h = q.poll();
			if(now_h == G) {
				System.out.println(building[now_h] -1);	
				return;
			}
				
			if(now_h + U <= F) {
				if(building[now_h+U] == 0) {
					building[now_h+U] = building[now_h] + 1;
					q.add(now_h + U);
				}
			}
			
			if(now_h - D > 0) {
				if(building[now_h - D] == 0) {
					building[now_h - D] = building[now_h] + 1;
					q.add(now_h - D);
				}
			}
			
		}
		System.out.println("use the stairs");
		return;
	}
}
