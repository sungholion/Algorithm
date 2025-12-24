import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int res = 0;

        if(A == B && B == C){   // 모두 같을 떄
            res = 10000 + A * 1000;
        } else if(A != B && B != C && A!= C){    // 모두 다를 때
            int max = A;
            if (B > max) max = B;
            if (C > max) max = C;
            res = max * 100;
        } else if(A == B){
            res = 1000 + A * 100;
        } else if(A == C){
            res = 1000 + A * 100;
        } else if(B == C){
            res = 1000 + B * 100;
        }

        System.out.print(res);
    }
}