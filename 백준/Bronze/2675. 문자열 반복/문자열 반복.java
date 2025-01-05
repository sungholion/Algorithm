import javax.sql.rowset.serial.SerialStruct;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int tc=0; tc<t; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            for(int i=0; i<str.length(); i++){
                for(int j=0; j<n; j++){
                    bw.write(str.charAt(i));
                }
            }
            bw.write("\n");
        }



        bw.flush();
        bw.close();
    }
}
