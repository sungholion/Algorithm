import java.io.*;
import java.text.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Date date = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));

        bw.write(df.format(date));
        bw.flush();
        bw.close();
    }
}