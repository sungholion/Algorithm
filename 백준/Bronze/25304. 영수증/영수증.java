import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        boolean flag = true;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            x -= a * b;

            if(x < 0){
                flag = false;
                break;
            }
        }
        
        if(flag && x == 0) bw.write("Yes\n");
        else bw.write("No\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
