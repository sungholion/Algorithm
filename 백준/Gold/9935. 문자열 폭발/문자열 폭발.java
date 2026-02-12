import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        int n = s.length();
        int m = bomb.length();
        char[] arr = s.toCharArray();
        char[] b = bomb.toCharArray();

        char[] stack = new char[n];
        int top = 0;

        for (int i = 0; i < n; i++) {
            stack[top++] = arr[i];

            if (top >= m && stack[top - 1] == b[m - 1]) {
                boolean same = true;
                for (int k = 0; k < m; k++) {
                    if (stack[top - m + k] != b[k]) {
                        same = false;
                        break;
                    }
                }
                if (same) top -= m;
            }
        }

        if (top == 0) {
            System.out.print("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < top; i++) {
                sb.append(stack[i]);
            }
            System.out.print(sb.toString());
        }
    }
}
