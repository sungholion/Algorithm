import java.io.*;
import java.util.*;

public class Main {
    public static int white;    // 흰색 count
    public static int blue;     // 파란색 count
    public static int[][] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        origin  = new int[N][N];

        for (int i = 0; i < N; i++) {   // 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                origin[i][j] = Integer.parseInt(st.nextToken());
        }

        paper(0, 0, N);
        sb.append(white).append("\n");
        sb.append(blue).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void paper(int row, int col, int size) {

        if(isFull(row, col, size)){
            if(origin[row][col] == 0){
                white++;
            }
            else
                blue++;
            return;
        }

        int tmpSize = size / 2;
        paper(row, col, tmpSize);
        paper(row + tmpSize, col, tmpSize);
        paper(row, col + tmpSize, tmpSize);
        paper(row + tmpSize, col + tmpSize, tmpSize);

    }

    public static boolean isFull(int row, int col, int size) {
        int color = origin[row][col];

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(origin[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}
