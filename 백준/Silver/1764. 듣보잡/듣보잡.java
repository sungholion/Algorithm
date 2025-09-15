import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> heard = new HashSet<>(N * 2);
        for (int i = 0; i < N; i++) {
            heard.add(br.readLine());
        }

        ArrayList<String> both = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (heard.contains(name)) both.add(name);
        }

        Collections.sort(both);
        StringBuilder sb = new StringBuilder();
        sb.append(both.size()).append('\n');
        for (String s : both) sb.append(s).append('\n');
        System.out.print(sb.toString());
    }
}
