import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=1;i<=n;i++){
            for(int j=0;j<n-i;j++) System.out.print(" ");
            for(int j=0;j<(i-1)*2+1;j++) System.out.print("*");
            System.out.println();
        }
        for(int i=n-1;i>=1;i--){
            for(int j=0;j<n-i;j++) System.out.print(" ");
            for(int j=0;j<(i-1)*2+1;j++) System.out.print("*");
            System.out.println();
        }
    }
}