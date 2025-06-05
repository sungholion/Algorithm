import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if(((A >= B) && (A >= C)) && (B >= C)){
            sb.append(B);
        } else if(((A >= B) && (A >= C)) && (C >= B)){
            sb.append(C);
        } else if(((B >= A) && (B >= C)) && (A >= C)){
            sb.append(A);
        } else if(((B >= A) && (B >= C)) && (C >= A)){
            sb.append(C);
        } else if(((C >= A) && (C >= B)) && (A >= B)){
            sb.append(A);
        } else if(((C >= A) && (C >= B)) && (B >= A)){
            sb.append(B);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}