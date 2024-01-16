import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int ans = 0;
		
		for (int i=0; i < input; i++) {
			int n = i;
			int sum = 0;
			
			while(n != 0) {
				sum += n % 10;
				n /= 10;
			}
			
			if (sum + i == input) {
				ans = i;
				break;
			}
				
		}
		
		System.out.println(ans);
	}
}
// 216 = 2 + 1 + 6 + 207
// 207 = 2 + 0 + 7 + 198
