import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for(int j = N - 1; j - i > 0; j--){
                sb.append(" ");
            }
            for(int k = 0; k <= i; k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
