import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static StringBuilder path = new StringBuilder();
    private static void hanoi(int n, int start, int mid, int end){
            if(n==1){
                path.append(start + " " + end + "\n");
                return;
            }
            hanoi(n-1, start, end, mid);
            path.append(start + " " + end + "\n");
            hanoi(n-1, mid, start, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());

        if(n <= 20){
            path.append((int)Math.pow(2, n) - 1).append("\n");
            hanoi(n, 1, 2, 3);
            System.out.print(path.toString());
        }
        else if(n > 20){
            BigInteger cnt = new BigInteger("1");
            for(int i=0; i<n; i++){
                cnt = cnt.multiply(new BigInteger("2"));
            }
            cnt = cnt.subtract(new BigInteger("1"));
            System.out.println(cnt);
        }
    }
}
