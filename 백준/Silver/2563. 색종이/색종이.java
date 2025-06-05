import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[101][101];
        int sum = 0;
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i=x; i<x+10; i++){
                for(int j=y; j<y+10; j++){
                    if(!arr[i][j]){
                        arr[i][j] = true;
                        sum++;
                    }
                }
            }
        }

        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}