import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] prevMax = new long[3];
        long[] prevMin = new long[3];
        long[] curMax = new long[3];
        long[] curMin = new long[3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (i == 0) {
                prevMax[0] = prevMin[0] = a;
                prevMax[1] = prevMin[1] = b;
                prevMax[2] = prevMin[2] = c;
                continue;
            }

            curMax[0] = Math.max(prevMax[0], prevMax[1]) + a;
            curMax[1] = Math.max(Math.max(prevMax[0], prevMax[1]),prevMax[2]) + b;
            curMax[2] = Math.max(prevMax[1], prevMax[2]) + c;

            curMin[0] = Math.min(prevMin[0], prevMin[1]) + a;
            curMin[1] = Math.min(Math.min(prevMin[0], prevMin[1]),prevMin[2]) + b;
            curMin[2] = Math.min(prevMin[1], prevMin[2]) + c;

            long[] tmp = prevMax; prevMax = curMax; curMax = tmp;
            tmp = prevMin; prevMin = curMin; curMin = tmp;
        }

        long ansMax = Math.max(prevMax[0], Math.max(prevMax[1], prevMax[2]));
        long ansMin = Math.min(prevMin[0], Math.min(prevMin[1], prevMin[2]));

        System.out.println(ansMax + " " + ansMin);
    }
}
