import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[][] arr = new int[10][10];
		
		for(int i=1; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<10; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int m_num = arr[1][1], m_low = 1, m_col = 1;
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				if(arr[i][j] > m_num) {
					m_num = arr[i][j];
					m_low = i;
					m_col = j;
				}
			}
		}
		System.out.println(m_num);
		System.out.println(m_low + " " + m_col);
		
	}
}