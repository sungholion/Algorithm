import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int n, k;
	static int[] map = new int[1000001];
	static boolean[] visited = new boolean[1000001];
	static int cnt = 1;	// 배열 초기값과 안헷갈리기 위해서
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
	
		bfs(n);
		
		bw.write(map[k] - 1 + "");	// 처음에 +1 해줬으므로 빼줌.
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		visited[start] = true;
		q.offer(start);
		map[start] = cnt;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int i=0; i<3; i++) {
				if(cur == k)
					return;
				if(i == 0 && (cur-1) >=0 && !visited[cur-1]) {	// x - 1 칸으로 이동
					q.offer(cur-1);
					map[cur-1] = map[cur] + 1;
					visited[cur-1] = true;
				}
				
				else if(i == 1 && (cur +1) < map.length && !visited[cur+1]) {	// x + 1 칸으로 이동
					q.offer(cur+1);
					map[cur+1] = map[cur] + 1;
					visited[cur+1] = true;
				}
				
				else if(i == 2 && (cur * 2) < map.length && !visited[cur*2]) {	// x * 2 칸으로 이동
					q.offer(cur*2);
					map[cur*2] = map[cur] + 1;
					visited[cur*2] = true;
				}
			}	
		}
		
		return;
		
	}
	
}