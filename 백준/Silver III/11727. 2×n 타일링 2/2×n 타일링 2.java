import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] table = new int[n+1];
		table[0] = 1;
		table[1] = 1;
		
		for(int i=2; i<=n; i++) {
			table[i] = (table[i-1] + table[i-2]*2) % 10007;
		}
		System.out.println(table[n]);
	
	}
}