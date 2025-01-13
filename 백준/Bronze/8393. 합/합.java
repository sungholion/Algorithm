import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Main {
	public static void main(String[] args) throws IOException {
        
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int s = 0;
        
		for( int i = 1 ; i <= N ; i++ ) s+=i;
 
		System.out.println(s);
	}
}