import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[10001];
        for(int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x]++;
        }

        for(int i = 1; i < 10001; i++) {
            for(int j = 0; j < arr[i]; j++){
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
