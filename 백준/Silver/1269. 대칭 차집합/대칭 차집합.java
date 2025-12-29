import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < N; t++) {
            int x = Integer.parseInt(st.nextToken());
            set1.add(x);
        }
        st = new StringTokenizer(br.readLine());
        for(int t = 0; t < M; t++) {
            int x = Integer.parseInt(st.nextToken());
            set2.add(x);
        }
        HashSet<Integer> set3 = new HashSet<>(set1);
        HashSet<Integer> set4 = new HashSet<>(set2);
        set3.removeAll(set2);
        set4.removeAll(set1);
        set3.addAll(set4);
        sb.append(set3.size()).append("\n");

        System.out.print(sb);
    }
}