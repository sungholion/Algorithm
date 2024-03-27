import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 곡 수
		int s = Integer.parseInt(st.nextToken());	// 시작 볼륨
		int m = Integer.parseInt(st.nextToken());	// 최대 볼륨
		
		int[] cur_vol = new int[m+1];	// 조절후 볼륨 기록할 배열
		for(int i=0; i<=m; i++)			// 초기화
			cur_vol[i] = -1;
		cur_vol[s] = 0;					// 초기 음량 ex) 음량이 s인 곡은 0번째이다.
		
		st = new StringTokenizer(br.readLine());	// 곡마다 조절할 수 있는 음량
		for(int i=1; i<=n; i++) {
			int cur_control = Integer.parseInt(st.nextToken());
			ArrayList<Integer> control = new ArrayList<>();
			
			for(int j=0; j<=m; j++) {
				if(cur_vol[j] == i-1) {
					int c_plus = j + cur_control;
					int c_minus = j - cur_control;
					
					if(c_plus >=0 && c_plus <= m) 
						control.add(c_plus);
					if(c_minus >= 0 & c_minus <= m) 
						control.add(c_minus);
				}
			}
			
			for(int c : control) 
				cur_vol[c] = i;
		}
		
	
		int ans = -1;
		for(int i=0; i<=m; i++) {
			if(cur_vol[i] == n) {
				if(ans <= i) ans = i;
			}
				
		}
		
		bw.write(ans + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
}
