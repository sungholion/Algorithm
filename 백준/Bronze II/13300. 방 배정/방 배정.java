import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] male_students = new int[7];
		int[] female_students = new int[7];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			if(S == 0)
				female_students[Y]++;	// 학년에 성별 나눠서 인원 저장
			else if(S == 1)
				male_students[Y]++;
		}
		
		int cnt_room = 0;
		for(int i=1; i<7; i++) {
			if(male_students[i] == 0) continue;
			else if(male_students[i] % K == 0) cnt_room += male_students[i] / K;
			else if(male_students[i] % K != 0) cnt_room += (male_students[i] / K)+1;
		}
		
		for(int i=1; i<7; i++) {
			if(female_students[i] == 0) continue;
			else if(female_students[i] % K == 0) cnt_room += female_students[i] / K;
			else if(female_students[i] % K != 0) cnt_room += (female_students[i] / K)+1;
		}
	
		System.out.println(cnt_room);
	}
}