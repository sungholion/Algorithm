import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n <= 100 && n >= 90){
            bw.write("A");
        } else if(n < 90 && n >= 80){
            bw.write("B");
        } else if(n < 80 && n >= 70){
            bw.write("C");
        } else if(n < 70 && n >= 60){
            bw.write("D");
        } else{
            bw.write("F");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
