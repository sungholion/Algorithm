import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> addressPassword = new HashMap<String, String>();
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			addressPassword.put(st.nextToken(), st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			sb.append(addressPassword.get(br.readLine())).append("\n");
		}
		System.out.println(sb);
	}

}