import java.util.*;
import java.io.*;

class Coord{
   int x;
   int y;

   Coord(int x, int y){
      this.x = x;
      this.y = y;
   }
}

public class Main{
   public static void main(String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      StringBuilder sb = new StringBuilder();
      StringTokenizer st;

      int n = Integer.parseInt(br.readLine());
      Coord[] coords = new Coord[n];
      for(int i = 0; i < n; i++){
         st = new StringTokenizer(br.readLine());
         Coord coord = new Coord(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
         coords[i] = coord;
      }

      Arrays.sort(coords, (a, b) -> {
         if (a.x != b.x) {
            return a.x - b.x;
         } else {
            return a.y - b.y;
         }
      });

      for(int i = 0; i < n; i++){
         sb.append(coords[i].x).append(" ").append(coords[i].y).append("\n");
      }

      bw.write(sb.toString());
      bw.flush();
      bw.close();
      br.close();
   }
}


