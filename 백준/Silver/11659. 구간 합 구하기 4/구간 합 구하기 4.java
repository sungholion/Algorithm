import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] input = new int[n+1];
		st = new StringTokenizer(br.readLine());
		
		int sum = 0;
		for(int i=1; i<=n; i++) {
			int num = Integer.parseInt(st.nextToken());
			sum+= num;
			input[i] = sum;
		}
		
		for(int o=0; o<m; o++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(input[end] - input[start-1]);
		}
	}
}

