import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String ans = "";
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i = 0; i < str.length(); i++){
                for(int j = 0; j < R; j++){
                    ans += str.charAt(i);
                }
            }
            bw.write(ans + "\n");

        }

        br.close();
        bw.flush();
        bw.close();
    }
}