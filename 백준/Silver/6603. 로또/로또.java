import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] s;
    static int[] pick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while(!(str =  br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(str);
            int k = Integer.parseInt(st.nextToken());
            s = new int[k]; // 집합 S
            pick = new int[6];  // 선정된 조합
            for(int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            comb(0, 0);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void comb(int start, int depth){
        if(depth == 6){
            for(int i = 0; i < 6; i++)
                sb.append(pick[i] + " ");
            sb.append("\n");
            return;
        }

        for(int i = start; i < s.length; i++){
            pick[depth] = s[i];
            comb(i + 1, depth + 1);
        }

    }
}
