import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int i,j;
    static int cnt;
	static int rotate;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] snail = new int[n][n];
			
			i =0; j=0;
			cnt = 1;
			rotate = 0;
			while(cnt < (n*n + 1)) {
				snail[i][j] = cnt++;
				
				i+= dx[rotate];
				j+= dy[rotate];
				
				if(i < 0 || j <0 || i >= n || j >= n || snail[i][j]!=0) {
					i -= dx[rotate];
					j -= dy[rotate];
				
					rotate = (rotate + 1) % 4;
					
					i += dx[rotate];
					j += dy[rotate];
					
				
				}
				
			}
			System.out.println("#" + tc);
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		
			}
		
	}
}
