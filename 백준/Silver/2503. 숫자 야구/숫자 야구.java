import java.io.*;
import java.util.*;

public class Main {
    static class Hint {
        int[] d = new int[3];
        int s, b;
        Hint(int num, int s, int b) {
            d[0] = num / 100;
            d[1] = (num / 10) % 10;
            d[2] = num % 10;
            this.s = s;
            this.b = b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Hint[] hints = new Hint[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            hints[i] = new Hint(num, s, b);
        }

        int ans = 0;

        for (int a = 1; a <= 9; a++) {
            for (int c = 1; c <= 9; c++) {
                if (c == a) continue;
                for (int e = 1; e <= 9; e++) {
                    if (e == a || e == c) continue;

                    int[] cand = {a, c, e};
                    boolean ok = true;

                    for (Hint h : hints) {
                        int strike = 0, ball = 0;
                        
                        for (int k = 0; k < 3; k++) {
                            if (cand[k] == h.d[k]) strike++;
                        }

                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                if (i == j) continue;
                                if (cand[i] == h.d[j]) ball++;
                            }
                        }

                        if (strike != h.s || ball != h.b) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok) ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
