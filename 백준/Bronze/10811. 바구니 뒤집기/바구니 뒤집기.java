import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N+1];
        for(int i = 1; i <= N; i++)
            basket[i] = i;

        for(int t = 0; t < M; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            for(int k = i, l = j ; k <= l; k++, l--){
                int temp = basket[k];
                basket[k] = basket[l];
                basket[l] = temp;
            }

        }
        
        for(int i = 1; i <= N; i++)
            sb.append(basket[i]).append(" ");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}