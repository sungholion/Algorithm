import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] ladder;
    static boolean[][] visited;
    static int finX, finY;
    static int ans;
    static int[] dx = {0, 0, -1};
    static int[] dy = {-1, 1, 0};
    public static void findStart(int x, int y){
        while(true){
            if(x==0){
                ans = y;
                break;
            }
            for(int i=0; i<3; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx>=0 && nx<100 && ny>=0 && ny<100 && ladder[nx][ny] == 1){
                    ladder[x][y] = -1;
                    x = nx;
                    y = ny;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int tc = 1; tc<=10; tc++){
            int t = Integer.parseInt(br.readLine());
            ladder = new int[100][100];
            visited = new boolean[100][100];

            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    if(ladder[i][j] == 2){
                        finX = i;
                        finY = j;
                    }
                }
            }
            findStart(finX, finY);
            System.out.println("#" + tc + " " + ans);

        }
    }
}
