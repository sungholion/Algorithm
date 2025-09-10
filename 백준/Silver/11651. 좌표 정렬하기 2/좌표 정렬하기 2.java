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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Coord[] coords = new Coord[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coords[i] = new Coord(x, y);
        }

        Arrays.sort(coords, (a, b) -> {
            if(a.y != b.y) return (a.y - b.y);
            return a.x - b.x;});

        for(Coord c : coords)
            sb.append(c.x).append(" ").append(c.y).append("\n");
        System.out.println(sb.toString());
    }
}