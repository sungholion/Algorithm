import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String res = a * b * c + "";

        int[] num = new int[10];
        for(int i=0; i<res.length(); i++){
            int idx = res.charAt(i) - '0';
            num[idx]++;
        }

        for(int x : num){
            bw.write(x + "\n");
        }


        bw.flush();
        bw.close();
    }
}
