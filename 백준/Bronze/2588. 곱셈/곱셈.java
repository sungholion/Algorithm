import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        int n1 = a * (b%10);
        int n2 = a * ((b%100)/10);
        int n3 = a * (b/100);
        sum = n1 + 10*n2 + 100*n3;

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(sum);


    }
}
