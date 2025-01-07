import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc < t; tc++){
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int customerH = n % h;
            if(customerH == 0) customerH = h;
            customerH *= 100;

            int customerW = (n - 1) / h + 1;

            bw.write(customerH + customerW + "\n");
        }

        bw.flush();
        bw.close();
    }
}
