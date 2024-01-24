import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] score = new int[n];
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i= 0; i<n; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = score[0];
		for(int i=1; i<n; i++) {
			if(score[i] > m)
				m = score[i];
		}
		
		double sum = 0;
		for(int i=0; i<n; i++) {
			sum += (double)score[i] / m * 100;
		}
		
		System.out.println(sum/n);
		
	}
}