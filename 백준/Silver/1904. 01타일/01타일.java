import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		long[] table = new long[10000001];
		
		table[1] = 1;
		table[2] = 2;
		
		for(int i=3; i<=n; i++) 
			table[i] = ( table[i-2] + table[i-1] )% 15746;

		System.out.println(table[n]);
	}
	
}