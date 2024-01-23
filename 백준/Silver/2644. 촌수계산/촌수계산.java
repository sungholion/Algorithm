import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, a, b, m;
	static int cnt = 0;
	static int ans = -1;
	static int[][] arr;
	static int[] nums;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1;
		
		n = Integer.parseInt(br.readLine());
		st1 = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st1.nextToken());
		b = Integer.parseInt(st1.nextToken());
		m = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		nums = new int[n + 1];
		
		for(int i=0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
			

			bfs(a);
			
		if(nums[b] == 0)
			System.out.println(-1);

		else 
			System.out.println(nums[b]);
		}
	
	
//	public static void dfs(int a) {
//		visited[a] = true;
//		if(a == b) {
//			return;
//		}
//		
//		for(int i = 1; i <= n; i++) {
//			if(arr[a][i] == 1 && !visited[i]) {
//				cnt++;
//				dfs(i);
//			}		
//		}
//		
//		
//	}
	
	public static void bfs(int a) {
		q.add(a);
		visited[a] = true;
		
		while(!q.isEmpty()) {
			a = q.poll();
			if(a==b) {
				ans = cnt;
				break;
			}
				
			for(int i=1; i<=n; i++) {
				if(arr[a][i] == 1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
					nums[i] = nums[a] +1;
				}
			}
		}
	}

}


