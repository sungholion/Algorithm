import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for (int test_case=0; test_case<n; test_case++) {
			String input = br.readLine();
			char[] str = input.toCharArray();
			
			int sum = 0;
			int k = 0;
			for(int i=0; i<str.length; i++) {
				if(str[i] == 'O') {
					k++;
					sum+=k;
				}
				else
					k = 0;
			}
			System.out.println(sum);
		}
		
	}
}



