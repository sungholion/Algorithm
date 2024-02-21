import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			a[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(a);
		
		int x = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		int i=0;
		int j=n-1;
		while(i<j) {
			int tmp = a[i] + a[j];
			
			if(tmp == x) cnt++;
			if(tmp < x) i++;
			else j--;
		}
		
		
		bw.write(cnt+"");
		
		bw.flush();
		bw.close();
		br.close();
		

	}
}