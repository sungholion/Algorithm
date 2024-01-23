import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		Set<Integer> myset = new HashSet<Integer>();
		
		for(int i=0; i<10; i++) {
			int n = Integer.parseInt(br.readLine());
			myset.add(n%42);
		}
		
		System.out.println(myset.size());
	
	}
}



