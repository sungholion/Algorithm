import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            Map<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());
            while (N-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 이름은 중복 안됌
                String kind = st.nextToken();
                if(map.containsKey(kind)) {
                    map.put(kind, map.get(kind)+1); // 종류 같으면 1 추가
                }
                else{
                    map.put(kind, 1);
                }
            }

            int ans = 1;    // 안입는 경우도 count

            for(int v : map.values()) 
                ans *= (v + 1);
            
            ans--;      // 전체 다 안입는 경우는 제외

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
