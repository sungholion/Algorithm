import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strtk = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(strtk.nextToken());
		int count = Integer.parseInt(strtk.nextToken()); 
		
		int temp = 0;
		
		int busket[] = new int[n];
		for(int i=0;i<busket.length;i++) {
			busket[i] = i+1;
		}
		
		for(int i=0;i<count;i++) {
			strtk = new StringTokenizer(br.readLine()," ");
			
			int a = Integer.parseInt(strtk.nextToken())-1;
			int b = Integer.parseInt(strtk.nextToken())-1;
			
			while(a<b) {
				temp = busket[a];
				busket[a] = busket[b];
				busket[b] = temp;
				a++;
				b--;
			}
		}
		
		br.close();
		
		for(int i=0;i<busket.length;i++) {
			System.out.print(busket[i]+" ");
		}
		
	}
}