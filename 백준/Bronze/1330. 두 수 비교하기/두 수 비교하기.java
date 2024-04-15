import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(a > b)
            sb.append(">").append("\n");
        else if(a < b)
            sb.append("<").append("\n");
        else
            sb.append("==").append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
