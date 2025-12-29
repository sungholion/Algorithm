import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for(int t = 0; t < N; t++) {
            String str = br.readLine();
            set1.add(str);
        }
        for(int t = 0; t < M; t++) {
            String str = br.readLine();
            set2.add(str);
        }
        set1.retainAll(set2);
        sb.append(set1.size()).append("\n");
        ArrayList<String> list = new ArrayList<>(set1);
        Collections.sort(list);

        for(String s : list) sb.append(s).append("\n");

        System.out.print(sb);
    }
}