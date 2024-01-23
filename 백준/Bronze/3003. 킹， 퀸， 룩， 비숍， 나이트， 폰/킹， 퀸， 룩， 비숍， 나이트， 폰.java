import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int[] num = new int[input.length];
		int[] com = {1, 1, 2, 2, 2, 8};
		int[] ans = new int[input.length];
		
		for(int i=0; i<input.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		
		for(int i=0; i<num.length; i++) {
			ans[i] = com[i] - num[i];
		}
		
		for(int i=0; i<ans.length; i++) {
			System.out.print(ans[i] +" ");
		}
		
		
	}
}



