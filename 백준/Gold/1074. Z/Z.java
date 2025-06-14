import java.io.*;
import java.util.*;

public class Main {
    static int N, r, c, ans;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int)Math.pow(2, N);
        find(0, 0, size);

        sb.append(ans).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void find(int row, int col, int size) {
        if(size == 1){
            return;
        }
        int newSize = size / 2;
        if((r < row + newSize) && (c < col + newSize)){
            find(row, col, newSize);
        }
        if((r < row + newSize) && (c >= col + newSize)){
            ans += (size * size) / 4;
            find(row, col + newSize, newSize);
        }
        if((r >= row + newSize) && (c < col + newSize)){
            ans += ((size * size) / 4) * 2;
            find(row + newSize, col, newSize);
        }
        if((r >= row + newSize) && (c >= col + newSize)){
            ans += ((size * size) / 4) * 3;
            find(row + newSize, col + newSize, newSize);
        }
    }

}
