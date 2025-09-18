import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>(N * 2); 
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();
            map.put(site, pw);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String q = br.readLine();
            sb.append(map.get(q)).append('\n');
        }
        System.out.print(sb.toString());
    }
}
