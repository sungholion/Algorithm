import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] farm = new int[n][n];
			
			for(int i=0; i<n; i++) {
				String num = br.readLine();
				for(int j=0; j<n; j++) 
					farm[i][j] = Character.getNumericValue(num.charAt(j));
			}
			
			int mid = n/2;
			int move = 0;
			int sum = 0;
			for(int i=0; i<n; i++) {
				sum += farm[i][mid];
				
				for(int add = 1; add<=move; add++) {
					sum += farm[i][mid-add];
					sum += farm[i][mid+add];
				}
				
				if(i < mid)
					move++;
				if(i >= mid)
					move--;
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
