import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {

            for(int j = 0; j < i; j++) {
                sb.append(' ');
            }

            for(int j = 0; j < (2*N-1-(2*i)); j++) {
                sb.append('*');
            }

            sb.append("\n");
        }


        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


}
