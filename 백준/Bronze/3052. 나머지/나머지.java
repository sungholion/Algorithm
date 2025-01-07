import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        boolean vis[] = new boolean[42];
        for(int i=0; i<10; i++){
            int n = Integer.parseInt(br.readLine());
            vis[n%42] = true;
        }

        for(int i=0; i<42; i++){
            if(vis[i]) {
                ans++;
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
