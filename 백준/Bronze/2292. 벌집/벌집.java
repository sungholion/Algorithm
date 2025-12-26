import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int ans = 1;
        int plus = 1;
        while(plus < N){
            plus += 6 * ans;
            ans++;
        }
        System.out.println(ans);
    }
}