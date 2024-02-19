import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main{
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		
		for(int i=0; i<K; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n == 0) s.pop();
			else s.push(n);
		}
		
		int sum = 0;
		while(!s.isEmpty())
			sum+= s.pop();
		System.out.println(sum);
	}
}
