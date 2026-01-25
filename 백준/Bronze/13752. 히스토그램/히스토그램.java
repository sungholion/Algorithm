import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < K; j++) sb.append('=');
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
