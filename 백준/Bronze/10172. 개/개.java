import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        bw.write("|\\_/|");
        bw.newLine();	// 줄 구분자

        bw.write("|q p|   /}");
        bw.newLine();

        bw.write("( 0 )\"\"\"\\");
        bw.newLine();

        bw.write("|\"^\"`    |");
        bw.newLine();

        bw.write("||_/=\\\\__|");

        bw.flush();
        bw.close();
    }
}
