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
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for(int i = 0; i < M; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        int cnt = 0;
        for(String x : map.keySet()) {
            if(map.get(x) > 1) {
                cnt++;
            }
        }

        sb.append(cnt + "\n");
        String[] s = new String[cnt];
        int i = 0;
        for(String x : map.keySet()) {
            if(map.get(x) > 1) {
                s[i++] = x;
            }
        }
        Arrays.sort(s);
        for(String x : s) {
            sb.append(x + "\n");
        }


        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}