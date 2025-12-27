import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        boolean ok = false;
        for (int i = 1; i < n; i++) {
            int temp = i;
            int sum = temp;
            while(temp > 0){
                sum += temp % 10;
                temp /= 10;
            }
            if(sum == n){
                System.out.print(i);
                ok = true;
                break;
            }
        }

        if(!ok) System.out.print(0);
    }
}
