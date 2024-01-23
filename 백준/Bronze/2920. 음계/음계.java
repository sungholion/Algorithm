import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int[] num = new int[8];
		
		for(int i=0; i<input.length; i++) 
			num[i] = Integer.parseInt(input[i]);
		
		if(num[0] == 1) {
			int start = 1;
			for(int i=0; i<num.length; i++) {
				if(num[i] != start++) {
					break;
				}
			}
			if (start == 9)
				System.out.println("ascending");
			else
				System.out.println("mixed");
		}
		
		else if(num[0] == 8) {
			int start = 8;
			for(int i=0; i<num.length; i++) {
				if(num[i] != start--) {
					break;
				}
			}
			if (start == 0)
				System.out.println("descending");
			else
				System.out.println("mixed");
		}
		
		else {
			System.out.println("mixed");
		}
		
		
	
	}
}



