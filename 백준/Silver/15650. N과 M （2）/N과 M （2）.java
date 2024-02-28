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
		
		dfs(1, 0);
		
		System.out.println(sb.toString());
	}
	
	static void dfs(int start, int depth) {
		if (depth == M) {
			for(int x : num) {
				sb.append(x).append(" ");
			}
			
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=N; i++) {
			num[depth] = i;
			dfs(i+1, depth+1);
		}
		
	}
	
}
