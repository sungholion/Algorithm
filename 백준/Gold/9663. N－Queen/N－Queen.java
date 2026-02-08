import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int answer = 0;

    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    static void dfs(int row) {
        if (row == N) {
            answer++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c]) continue;
            if (diag1[row - c + N]) continue;
            if (diag2[row + c]) continue;

            col[c] = true;
            diag1[row - c + N] = true;
            diag2[row + c] = true;

            dfs(row + 1);

            col[c] = false;
            diag1[row - c + N] = false;
            diag2[row + c] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        dfs(0);
        System.out.println(answer);
    }
}
