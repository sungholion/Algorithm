import java.io.*;
import java.util.*;

public class Main {
    static char[][] white = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };

    static char[][] black = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) map[i] = br.readLine().toCharArray();

        int ans = Integer.MAX_VALUE;

        for (int sr = 0; sr <= N - 8; sr++) {
            for (int sc = 0; sc <= M - 8; sc++) {
                int cntW = 0; 
                int cntB = 0; 

                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        if (map[sr + r][sc + c] != white[r][c]) cntW++;
                        if (map[sr + r][sc + c] != black[r][c]) cntB++;
                    }
                }

                ans = Math.min(ans, Math.min(cntW, cntB));
            }
        }

        System.out.println(ans);
    }
}
