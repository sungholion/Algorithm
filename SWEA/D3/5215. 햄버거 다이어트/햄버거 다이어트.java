import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import org.xml.sax.helpers.AttributeListImpl;

public class Solution {
	static int N, L;	
	static int[] tas;
	static int[] kal;
	static boolean[] isSelected;
	static int[] choice;
	static int tot_tas;
	static int max_tas;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());	// Test Case 수
		
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());	// 재료의 수 N
			L = Integer.parseInt(st.nextToken());	// 제한 칼로리 L
			
			tas = new int[N];
			kal = new int[N];
			isSelected = new boolean[N];
			choice = new int[N];
			
			for(int i=0; i<N; i++) {	
				st = new StringTokenizer(br.readLine());
				tas[i] = Integer.parseInt(st.nextToken());
				kal[i] = Integer.parseInt(st.nextToken());
			}
			
			max_tas = 0;
			bestFood(0,0);
			bw.write("#" + tc  + " " + max_tas + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bestFood(int cnt, int sum) {
		if(cnt == N) {
			if(sum <= L) {
				tot_tas = 0;
				for(int i=0; i<N; i++) {
					if(isSelected[i]) tot_tas += tas[i];
				}
				if(tot_tas > max_tas)
					max_tas = tot_tas;
			}
			return;
		}
		
		isSelected[cnt] = true;
		bestFood(cnt+1, sum + kal[cnt]);
		isSelected[cnt] = false;
		bestFood(cnt+1, sum);
	}
	
}
