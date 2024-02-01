import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] bug;
	static int kill;
	static int max_kill;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());	// 영역 넓이
			int m = Integer.parseInt(st.nextToken());	// 파리채 넓이
			bug = new int[n][n];
			for(int i=0; i<n; i++) {	// 영역 속 파리 수 입력
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					bug[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			max_kill = 0;
			for(int i=0; i<n-m+1; i++) {
				for(int j=0; j<n-m+1; j++) {
					for(int k=0; k<m; k++) {
						for(int l=0; l<m; l++) {
							kill += bug[i+k][j+l];
						}
					}
					if(kill > max_kill) {
						max_kill = kill;
					}
					kill = 0;
				}
			}
			
			
			System.out.println("#" + tc + " " + max_kill);
			
		}
		
		
	}
}
