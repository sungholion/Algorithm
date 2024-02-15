import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] table;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		table = new int[n+1];
		table[1] = 0;
		
		makeOne();
		
		
		bw.write(Integer.toString(table[n]));
		
		bw.flush();
		bw.close();
		br.close();
	}

	static void makeOne() {
		for(int i=2; i<=n; i++) {
			table[i] = table[i-1] + 1;
			if(i%3 == 0)
				table[i] = Math.min(table[i], table[i/3] + 1);
			if(i%2 == 0)
				table[i] = Math.min(table[i], table[i/2] + 1);
		
		}
	}
}