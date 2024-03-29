import java.io.*;
import java.util.*;

class Coord{	// 좌표를 담기 위한 클래스
	int x;
	int y;
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static int n, m;
	static int[][] cumSum;	// Cumulative sum (누적합)
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());	// 표의 크기
		m = Integer.parseInt(st.nextToken());	// 합을 구해야 하는 횟수
	
		cumSum = new int[n+1][n+1];				// 인덱스가 1부터 시작하므로
		
		for(int i=1; i<=n; i++) {				// 누적 합 테이블 만들기 (행 별로 누적합)
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) 
				cumSum[i][j] = cumSum[i][j-1] + Integer.parseInt(st.nextToken());
		}

		for(int loop=0; loop<m; loop++) 
		{
			st = new StringTokenizer(br.readLine());
			Coord c1 = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			Coord c2 = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			int ans = 0;
			for(int i=c1.x; i<=c2.x; i++) // 정해진 구간을 행별로 누적합 구함
				ans += cumSum[i][c2.y] - cumSum[i][c1.y - 1];	// 이번행 전체의 누적합에서, 구간 시작 점 이전까지의 누적합을 빼기
			
			sb.append(ans + "\n");
		}		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	

}
