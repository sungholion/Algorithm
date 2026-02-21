import java.io.*;

public class Main {

    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new char[n][n];

        draw(0, 0, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void draw(int x, int y, int size) {

        if (size == 1) {
            arr[x][y] = '*';
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (i == 1 && j == 1) {
                    fillBlank(x + newSize, y + newSize, newSize);
                } else {
                    draw(x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }

    static void fillBlank(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                arr[i][j] = ' ';
            }
        }
    }
}