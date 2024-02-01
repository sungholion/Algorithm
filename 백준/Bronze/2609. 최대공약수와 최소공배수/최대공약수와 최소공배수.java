import java.util.Scanner;
 
public class Main {
	static int b, s;
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
 
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		if(n1 >= n2) {
			b = n1;
			s = n2;
		}
		else {
			b = n2;
			s = n1;
		}
		System.out.println(gcd(b, s));
		System.out.println(lcm(b, s));
		
	}
	public static int gcd(int big, int small) {
		if(small==0) return big;
		return gcd(small, big%small);
	}
	
	public static int lcm(int big, int small) {
		return big * small / gcd(big, small);
	}
}