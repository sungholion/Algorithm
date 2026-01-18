import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));

    }
    static long factorial(long n){
        if(n <= 1) return 1;
        return n * factorial(n-1);
    }
}
