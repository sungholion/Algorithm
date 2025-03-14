import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long res = 1;
        if(n == 0){
            bw.write("1\n");
        } else{
            for(int i = n; i>0; i--){
                res *= i;
            }
            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
