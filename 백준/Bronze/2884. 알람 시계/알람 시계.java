import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int h = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		
		if (m - 45 < 0) {
			h-= 1;
			if(h < 0)
				h = 23;
			m += 15;
		}
		else
			m -= 45;
		
		System.out.println(h + " " + m);
	}
}
