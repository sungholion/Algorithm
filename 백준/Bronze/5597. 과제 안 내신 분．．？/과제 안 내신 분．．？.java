import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] vis = new boolean[31];

        for(int i=1; i<=28; i++){
            int num = Integer.parseInt(br.readLine());
            vis[num] = true;
        }

        for(int i=1; i<=30; i++){
            if(!vis[i]){
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
