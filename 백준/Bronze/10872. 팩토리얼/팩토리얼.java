import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long anw = 1L;
        for ( int i = 1 ; i <= n ; i++ )
            anw *= i;

        System.out.println(anw);
    }
}
