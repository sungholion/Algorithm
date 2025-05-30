import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int y = N % H;
            int x = N / H + 1;

            if(y == 0){
                y = H;
                x--;
            }

            if(x < 10){
                bw.write(y + "0" + x + "\n");
            } else {
                bw.write(y + "" + x + "\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
