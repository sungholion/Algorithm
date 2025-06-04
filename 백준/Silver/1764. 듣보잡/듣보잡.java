import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str) == 2)
                list.add(str);
        }
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(String x : list)
            sb.append(x).append('\n');

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}