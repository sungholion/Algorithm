import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N-2; i++) {
            int card1 = arr[i];
            for(int j = i+1; j < N-1; j++) {
                int card2 = arr[j];
                for(int k = j+1; k < N; k++) {
                    int card3 = arr[k];
                    int sum = card1 + card2 + card3;
                    if(sum > max && sum <= M){
                        max = sum;
                    }
                }
            }
        }
        System.out.print(max);
    }
}
