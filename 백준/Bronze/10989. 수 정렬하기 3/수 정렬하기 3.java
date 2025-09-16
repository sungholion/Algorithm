import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001];
        for(int i = 0; i < N; i++) {
           cnt[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 0; i < 10001; i++){
            if(cnt[i] != 0)
                while(cnt[i]-- > 0)
                    sb.append(i).append("\n");
        }

        System.out.println(sb);

    }
}
