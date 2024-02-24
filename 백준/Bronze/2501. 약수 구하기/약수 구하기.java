import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new LinkedList<>();
		
		for(int i=1; i<=n; i++) {
			if(n % i == 0) {
				list.add(i);
			}
		}
		
		
//		for(int i=0; i<list.size(); i++) System.out.print(list.get(i) +" ");
		if(list.size() < k) System.out.println(0);
		else
			System.out.println(list.get(k-1));
		
	}
}