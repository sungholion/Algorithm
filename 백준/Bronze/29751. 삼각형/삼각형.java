import java.io.*;
import java.util.StringTokenizer;

public class Main {
   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        double ans = (double)w * h /2;

       System.out.println(ans);
    }
}