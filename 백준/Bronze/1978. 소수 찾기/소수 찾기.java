import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int total = 0;
		for(int l=0; l<n; l++) {
			int input = sc.nextInt();
			int cnt = 0;
			for(int i=2; i<=input; i++) {
				if(input % i == 0)
					cnt++;
			}
			if(cnt == 1)
				total++;
		}
		System.out.println(total);
	}
}