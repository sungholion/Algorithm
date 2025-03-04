import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        BigInteger numA = sc.nextBigInteger();
        BigInteger numB = sc.nextBigInteger();

        sb.append(numA.multiply(numB));
        System.out.println(sb.toString());
    }
}