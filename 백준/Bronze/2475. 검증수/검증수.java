import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=0; i<5; i++){
            sum += (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
        }

        bw.write(sum % 10 + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
}