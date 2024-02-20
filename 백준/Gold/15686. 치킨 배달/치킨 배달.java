import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main{
	static int N, M;
	static List<int[]> chicken, home;
	static boolean[] isSelected;
	static int res = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());	// 도시의 크기 N x N
		M = Integer.parseInt(st.nextToken());	// 폐업시키지 않을 치킨집 개수
		
		home = new ArrayList<>();
		chicken = new ArrayList<>();
		
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp == 0) continue;	// 빈칸
				else if(temp == 1) home.add(new int[] {i,j});	// 집
				else if(temp == 2) chicken.add(new int[] {i,j});	// 치킨집
			}
		}
		
		isSelected = new boolean[chicken.size()];
		
		comb(-1, 0);
		
		bw.write(res+"");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void comb(int idx, int cnt) {
		if(cnt == M) {
			int dis = 0;
			
			for(int[] h : home) {
				int tmp = Integer.MAX_VALUE;
				for(int i=0; i<isSelected.length; i++) {
					if(isSelected[i]) {
						tmp = Math.min(tmp, Math.abs(h[0] - chicken.get(i)[0]) + Math.abs(h[1] - chicken.get(i)[1]));
					}
				}
				dis += tmp;
			}
			res = Math.min(res, dis);
			return;
		}
		
		for(int i=idx+1; i<chicken.size(); i++) {
			isSelected[i] = true;
			comb(i, cnt + 1);
			isSelected[i] = false;
		}
		
	}
	
}