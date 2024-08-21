import java.util.*;
import java.io.*;

public class Main{
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());

       for(int i=1; i<10; i++){
          sb.append(n + " * " + i + " = " + (n * i) + "\n");
       }


       bw.write(sb.toString());
       bw.flush();
       br.close();
       bw.close();
   }
}