import javax.sql.rowset.serial.SerialStruct;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        bw.write((a + b - c) + "\n");
        bw.write(Integer.parseInt(a + "" + b) - c + "\n");

        bw.flush();
        bw.close();
    }
}
