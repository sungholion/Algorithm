import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	static int N, M;
	static int[] num;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[M];
		visited = new boolean[N+1];
		
		dfs(0);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int depth) {
		if (depth == M) {
			for(int x : num) {
				sb.append(x).append(" ");
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				num[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
		
	}
	
}
