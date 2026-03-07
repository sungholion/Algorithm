import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            int cnt = 0;

            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == 'O') cnt++;
            }

            if(cnt > M/2) result++;
        }

        System.out.println(result);
    }
}