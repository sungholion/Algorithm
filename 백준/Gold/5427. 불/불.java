import java.awt.Point;
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
  static int w, h;
  static char[][] map;
  static boolean[][] visited;
  static int[] dx = {0, 0, 1, -1};
  static int[] dy = {1, -1, 0, 0};
  static Queue<Coord> fire;
  static StringBuilder sb;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    int startX = 0, startY = 0;
    for(int t=0; t < T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      map = new char[h][w];
      fire = new LinkedList<>();

      for(int i=0; i<h; i++){
        String input = br.readLine();
        for(int j=0; j<w; j++){
          map[i][j] = input.charAt(j);

          if(map[i][j] == '@'){
            startX = i;
            startY = j;
          }

          if(map[i][j] == '*')
            fire.add(new Coord(i, j));
        }
      }

      runToExit(new Coord(startX, startY));



    }

    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();

  }

  static void runToExit(Coord v){
    Queue<Coord> q = new LinkedList<>();
    visited = new boolean[h][w];
    visited[v.x][v.y] = true;
    q.offer(new Coord(-1, -1));
    q.offer(new Coord(v.x, v.y));
    int time = -1;

    while(!q.isEmpty()){
      Coord c = q.poll();

      if(c.x == -1 && c.y == -1) {
        burn();
        if(!q.isEmpty())
          q.offer(c);
        time++;
        continue;
      }


      for(int i=0; i<4; i++){
        int nx = c.x + dx[i];
        int ny = c.y + dy[i];

        if(nx >= h || ny >= w || nx < 0 || ny < 0) {
          sb.append(time+1 + "\n");
          return;
        }
        if(map[nx][ny] == '.' && !visited[nx][ny]) {
          q.offer(new Coord(nx, ny));
          visited[nx][ny] = true;
        }

      }
    }
    sb.append("IMPOSSIBLE\n");
  }

  public static void burn() {
    int size = fire.size();

    for(int s = 0; s < size; s++) {
      Coord c = fire.poll();

      for(int i = 0; i < 4; i++) {
        int nx = c.x + dx[i];
        int ny = c.y + dy[i];

        if(nx >= 0 && ny >= 0 && nx < h && ny < w && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
          fire.offer(new Coord(nx, ny));
          map[nx][ny] = '*';
        }
      }
    }
  }
}
