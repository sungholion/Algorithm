import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = n/4;
		
		for(int i=0; i<cnt; i++)
			System.out.print("long ");
		System.out.println("int");
		
	}
}



