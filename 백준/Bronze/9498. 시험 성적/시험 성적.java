import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());

        if(a>=90) sb.append("A");
        else if(a>=80) sb.append("B");
        else if (a>=70) sb.append("C");
        else if(a>=60) sb.append("D");
        else sb.append("F");


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
