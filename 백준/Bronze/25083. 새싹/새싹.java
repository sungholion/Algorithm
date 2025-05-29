import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = "         ,r'\"7\n" +
                "r`-_   ,'  ,/\n" +
                " \\. \". L_r'\n" +	
                "   `~\\/\n" +		
                "      |\n" +		
                "      |";

        bw.write(s);
        bw.flush();
        bw.close();
    }
}
