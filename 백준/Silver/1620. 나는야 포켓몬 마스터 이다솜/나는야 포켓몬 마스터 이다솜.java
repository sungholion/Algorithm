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

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> nextmap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(name, i);
            nextmap.put(i, name);
        }

        for(int i = 1; i <= M; i++) {
            String x = br.readLine();
            char ch = x.charAt(0);
            if(ch >= '0' && ch <= '9') {
               sb.append(nextmap.get(Integer.parseInt(x))).append("\n");
            } else {
                sb.append(map.get(x)).append("\n");
            }
        }




        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}