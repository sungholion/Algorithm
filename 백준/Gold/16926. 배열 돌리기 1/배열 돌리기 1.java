import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < R; i++){
            rotate();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(arr[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void rotate(){
        int layer = Math.min(N, M) / 2;

        for(int i = 0; i < layer; i++){
            int temp = arr[i][i];

            // ◀ 당기기
            for(int j = i; j < M - 1 - i; j++){
                arr[i][j] = arr[i][j+1];
            }

            // ▲ 당기기
            for(int j = i; j < N - 1 - i; j++){
                arr[j][M-1-i] = arr[j+1][M-1-i];
            }

            // ▶ 당기기
            for(int j = M - 1 - i; j > i; j--){
                arr[N-1-i][j] =  arr[N-1-i][j-1];
            }

            // ▼ 당기기
            for(int j = N - 1 - i; j > i + 1; j--){
                arr[j][i] = arr[j-1][i];
            }

            arr[i+1][i] = temp;
        }
    }
}