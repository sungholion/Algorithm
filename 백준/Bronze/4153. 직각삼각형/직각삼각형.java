import com.sun.source.tree.UsesTree;

import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0 && b == 0 && c == 0)
                break;

            if(a > b && a > c){
                if((a*a) == (b*b + c*c)){
                    sb.append("right\n");
                } else{
                    sb.append("wrong\n");
                }
            } else if(b > a && b > c){
                if((b*b) == (a*a + c*c)){
                    sb.append("right\n");
                } else{
                    sb.append("wrong\n");
                }
            } else if(c > a && c > b){
                if((c*c) == (a*a + b*b)){
                    sb.append("right\n");
                } else{
                    sb.append("wrong\n");
                }
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}