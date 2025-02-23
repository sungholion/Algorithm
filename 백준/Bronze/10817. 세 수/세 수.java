import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
 
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
 
		if (a >= b) {
			if (a >= c) {
				if (b >= c)
					System.out.println(b);
				else
					System.out.println(c);
			} else
				System.out.println(a);
		} else {
			if (c <= b) {
				if (c <= a)
					System.out.println(a);
				else
					System.out.println(c);
			} else
				System.out.println(b);
		}
	}
}