import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i+1;
        }

        for (int i = 0; i < M; i++) {
            int tmp;
            st = new StringTokenizer(br.readLine(), " ");
            int F = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            tmp = arr[F-1];
            arr[F-1] = arr[E-1];
            arr[E-1] = tmp;
        }
        br.close();

        for (int baguni : arr)
            sb.append(baguni).append(" ");
            System.out.println(sb);
    }
}
