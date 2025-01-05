import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        if(n == 0){
            bw.write("1\n");
        } else{
            int res = 1;
            for(int i=1; i<=n; i++){
                res *= i;
            }
            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
    }
}
