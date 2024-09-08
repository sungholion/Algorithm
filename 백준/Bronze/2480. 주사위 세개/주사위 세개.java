import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n3 = Integer.parseInt(st.nextToken());

        int res = 0;
        if(n1 == n2 && n2 == n3){
            res = 10000 + (n1 * 1000);
        } else if(n1 == n2 && n2 != n3){
            res = 1000 + (n1 * 100);
        } else if(n1 == n3 && n2 != n3){
            res = 1000 + (n1 * 100);
        } else if(n2 == n3 && n1 != n2){
            res = 1000 + (n2 * 100);
        } else if(n1 != n2 && n2 != n3){
            int max = n1;
            if(n2 > max) max = n2;
            if(n3 > max) max = n3;
            res = 100 * max;
        }

        bw.write(res + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
