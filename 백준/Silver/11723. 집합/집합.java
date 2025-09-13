import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        int bitmask = 0; // 공집합 시작

        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");

            switch (cmd[0]) {
                case "add":
                    int x1 = Integer.parseInt(cmd[1]);
                    bitmask |= (1 << x1);
                    break;

                case "remove":
                    int x2 = Integer.parseInt(cmd[1]);
                    bitmask &= ~(1 << x2);
                    break;

                case "check":
                    int x3 = Integer.parseInt(cmd[1]);
                    sb.append((bitmask & (1 << x3)) != 0 ? "1\n" : "0\n");
                    break;

                case "toggle":
                    int x4 = Integer.parseInt(cmd[1]);
                    bitmask ^= (1 << x4);
                    break;

                case "all":
                    bitmask = (1 << 21) - 1; // 1~20 모두 포함
                    break;

                case "empty":
                    bitmask = 0;
                    break;
            }
        }

        System.out.print(sb);
    }
}
