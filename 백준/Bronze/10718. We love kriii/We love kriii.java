import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        sb.append("강한친구 대한육군\n강한친구 대한육군");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}