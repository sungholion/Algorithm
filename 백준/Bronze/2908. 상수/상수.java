import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		StringBuffer str = new StringBuffer(input);
		String reversedStr = str.reverse().toString();
		
		String[] org = reversedStr.split(" ");
		
		int a = Integer.parseInt(org[0]);
		int b = Integer.parseInt(org[1]);
		
		if(a > b)
			System.out.println(a);
		else
			System.out.println(b);
	}
}



