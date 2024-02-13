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
		long[] table = new long[91];
		
		table[1] = 1;
		table[2] = 1;
		
		for(int i=2; i<=n; i++)
			table[i] = table[i-2] + table[i-1];
		
		System.out.println(table[n]);
		
	}
	
}