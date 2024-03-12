import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;




public class Main
{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String org = br.readLine();
        String search = br.readLine();
        org = org.replaceAll(search, "1");

        int cnt = 0;
        for(int i=0; i<org.length(); i++){
            if(org.charAt(i) == '1') cnt++;
        }

        bw.write(cnt+"");
        bw.close();
        br.close();

    }
}
