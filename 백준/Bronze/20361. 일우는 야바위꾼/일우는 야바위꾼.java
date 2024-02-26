import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] cup = new int[n+1];	
			cup[x] = 1; // 공이 있는 위치
			
			for(int change=0; change<k; change++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				int temp = cup[a];	// 컵 위치 교환
				cup[a] = cup[b];
				cup[b] = temp;
				
			}
			
			int res = 0;
			for(int i=1; i<=n; i++) {
				if(cup[i] == 1) res = i;	// 1이 공이 있는 위치
			}
			
			sb.append(res).append("\n");
			
		
		
		System.out.println(sb.toString());
	}
}
