import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ts = new int[6];
        for(int i = 0; i < 6; i++)
            ts[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int tAnswer = 0;
        int pBig = 0;
        int pSmall = 0;

        for(int i = 0; i < 6; i++){
            tAnswer += ts[i] / T;
            if(ts[i] % T != 0) tAnswer++;
        }

        sb.append(tAnswer).append("\n");
        sb.append(N/P).append(" ").append(N%P);
        System.out.print(sb);
    }
}
