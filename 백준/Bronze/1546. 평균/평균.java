import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        double max = -1;
        double[] arr = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max) {max = arr[i];}
        }
        double sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = arr[i] / max * 100;
            sum += arr[i];
        }
        System.out.println(sum / N);


    }
}
