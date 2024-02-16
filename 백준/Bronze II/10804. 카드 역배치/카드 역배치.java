import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] card = new int[21];
		for(int i=1; i<=20; i++) card[i] = i;
		
		for(int loop=0; loop<10; loop++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int i=0; i< (b-a+1)/2; i++) {
				int temp = card[a+i];
				card[a+i] = card[b - i];
				card[b-i] = temp;
			}
		
		}
		
		for(int i=1; i<=20; i++) System.out.print(card[i] + " ");
	}
}