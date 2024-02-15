import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//	입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] leak = new int[N];
	
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) 
			leak[i] = Integer.parseInt(st.nextToken());
		
		// 구현
		
		Arrays.sort(leak);	// 오름차순 정렬 후.
		int tape = (int)(leak[0] + L - 0.5);	// 테이프 범위
		int cnt = 1;
		for(int i=1; i<N; i++) {
			if( (int)(leak[i] + 0.5) > tape ) {
				tape = (int)(leak[i] + L - 0.5);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}