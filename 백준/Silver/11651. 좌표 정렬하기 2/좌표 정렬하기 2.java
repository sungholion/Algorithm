import java.io.*;
import java.util.*;

class Coord{
    int x;
    int y;

    Coord(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Coord[] coords = new Coord[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(coords, (a, b) -> {
            if(a.y == b.y) return a.x - b.x;
            return a.y - b.y;
        });

        for(int i = 0; i < N; i++){
            sb.append(coords[i].x + " ").append(coords[i].y).append("\n");
        }
        System.out.print(sb.toString());
    }
}
