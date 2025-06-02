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
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Coord[] coords = new Coord[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i] = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(coords, new Comparator<Coord>(){
            public int compare(Coord o1, Coord o2){
                if(o1.y == o2.y)
                    return o1.x - o2.x;
                else
                    return o1.y - o2.y;
            }
        });

        for(int i = 0; i < N; i++){
            sb.append(coords[i].x).append(" ").append(coords[i].y).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
