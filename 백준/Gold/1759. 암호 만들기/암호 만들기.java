import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static char[] pwOrg;
    static char[] pick;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pwOrg = new char[C];
        pick = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++)
            pwOrg[i] = st.nextToken().charAt(0);

        Arrays.sort(pwOrg); // 암호는 증가하는 순서로만
        comb(0, 0);

        System.out.print(sb);
    }

    static void comb(int start, int depth){
//        if (s.length - start < 6 - depth) return; // 가지치기?

        if(depth == L){
            boolean canMake = false;
            int cnt1 = 0; // 모음 개수 최소 1개
            int cnt2 = 0; // 자음 개수 최소 2개
            for(int i = 0; i < L; i++){
                if(pick[i] == 'a' || pick[i] == 'e' || pick[i] == 'i'
                || pick[i] == 'o' || pick[i] == 'u'){
                    cnt1++;
                }
                else{
                    cnt2++;
                }
            }

            if(cnt1 < 1 || cnt2 < 2) return;

            for(int i = 0; i < L; i++)
                sb.append(pick[i]);
            sb.append("\n");
            return;
        }

        for(int i = start; i < pwOrg.length; i++){
            pick[depth] = pwOrg[i];
            comb(i + 1, depth + 1);
        }

    }
}
