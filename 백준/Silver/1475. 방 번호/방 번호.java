import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] num = new int[10];
		
		for(int i=0; i<str.length(); i++) {
			int x = str.charAt(i) - '0';
			if(x == 9) num[6]++;
			else num[x]++;
		}
		
		if(num[6] % 2 == 1) num[6] = num[6]/2 +1;	// 홀수면 +1
		else num[6] = num[6] / 2;
		
		int max = 0;
		for(int i :num) max = Math.max(max, i);
		
		System.out.println(max);
		
		

	}
}