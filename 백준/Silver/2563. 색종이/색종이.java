import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine()); // 색종이의 수
		int[][] colorPaper = new int[100][100];	// 전체 색종이 넓이
		
		for(int t=0; t<n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int i=x; i<x+10; i++) 
				for(int j=y; j<y+10; j++) 
					colorPaper[i][j] = 1;	// 종이 색칠
		}
		
		int area = 0;
		for(int i=0; i<100; i++) 
			for(int j=0; j<100; j++) 
				if(colorPaper[i][j] == 1) area++;	// 색칠된 부분이라면 넓이+1
		
//		System.out.println(area);
		bw.write(Integer.toString(area));	// write : 정수를 유니코드로 출력하므로 문자열로 바꿈
		bw.flush(); bw.close(); br.close(); // 출력 닫기
	}
}