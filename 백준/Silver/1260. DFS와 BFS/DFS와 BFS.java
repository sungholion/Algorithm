import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, v;
	static int[][] arr;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(st1.nextToken());
		v = Integer.parseInt(st1.nextToken());
		
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			arr[a][b] = arr[b][a] = 1;
		}
			dfs(v);
			sb.append("\n");
			visited = new boolean[n+1];
			
			bfs(v);
			sb.append("\n");
			
			System.out.println(sb);
			
		}
	
	
	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");
		
		for(int i = 1; i <= n; i++) {
			if(arr[v][i] == 1 && !visited[i])
				dfs(i);
		}
	}
	public static void bfs(int v) {
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			v = q.poll();
			sb.append(v + " ");
			
			for(int i=1; i<=n; i++) {
				if(arr[v][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
	}

}


