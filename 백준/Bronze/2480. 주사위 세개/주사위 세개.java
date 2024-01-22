import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n1 = Integer.parseInt(input[0]);
		int n2 = Integer.parseInt(input[1]);
		int n3 = Integer.parseInt(input[2]);
		
		
		int m = 0;
		if((n1 == n2) && (n2 == n3)) {
			m = 10000 + n1 * 1000;
		} else if((n1 == n2 && n2!=n3) || (n1 == n3 && n2!=n3) || (n2 == n3 && n1!=n3)) {
			if(n1 == n2)
				m = 1000 + n1*100;
			else if(n1 == n3)
				m = 1000 + n1*100;
			else if(n2 == n3)
				m = 1000 + n2*100;
		} else {
			int max = -1;
			for(int i=0; i<3; i++) {
				if(Integer.parseInt(input[i]) > max) {
					max = Integer.parseInt(input[i]);
				}
			}
			m = max * 100;
		}
		System.out.println(m);
		}
	}




