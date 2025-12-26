import java.io.*;
import java.util.*;

class Coord{
    int x;
    int y;
    int val;

    Coord(int x, int y, int val){
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int max = -1;
        Coord ans = new Coord(-1, -1, -1);
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                int n = Integer.parseInt(st.nextToken());
                if(n > max){
                    max = n;
                    ans = new Coord(i, j, max);
                }
            }
        }
        sb.append(ans.val).append("\n").append(ans.x+1).append(" ").append(ans.y+1);
        System.out.print(sb);
    }
}