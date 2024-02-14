import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		sugar(n);
	}

	static void sugar(int x) {
		int cnt = 0;

		
		while(true) {
			if(x % 5 == 0) {
				cnt+= x / 5;
				System.out.println(cnt);
				break;
			}
			else {
				x -= 3;
				cnt++;
			}
			
			if(x < 0) {
				System.out.println(-1);
				break;
			}
		
		}
		
		
	}
}