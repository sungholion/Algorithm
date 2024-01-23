import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		String str = Integer.toString(a*b*c);
		char[] anw = str.toCharArray();
		char[] com = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		int[] cnt = new int[10];
		
		for(int i=0; i<10; i++) {
			for(int j=0; j<anw.length; j++) {
				if(anw[j] == com[i])
					cnt[i]++;
			}
		}
		
		for(int i=0; i<com.length; i++)
			System.out.println(cnt[i]);
	
	}
}



