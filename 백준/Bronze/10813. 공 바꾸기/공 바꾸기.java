import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n+1];
		
		for(int i=1; i<n+1; i++) 
			arr[i] = i;
			
		
		for(int cnt=0; cnt<m; cnt++) {
			st = new StringTokenizer(br.readLine());
			int i= Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int temp;
			
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		
		for(int i=1; i<n+1; i++)
			System.out.print(arr[i] + " ");

	}
}