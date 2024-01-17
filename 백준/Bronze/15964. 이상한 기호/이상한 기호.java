import java.util.Scanner;

class Cal {
	long a;
	long b;
	
	void print(long a, long b) {
		long result = (a+b) * (a-b);
		System.out.println(result);
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		Cal c = new Cal();
		c.print(a, b);
	}
}