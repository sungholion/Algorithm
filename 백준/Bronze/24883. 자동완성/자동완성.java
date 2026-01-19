import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char ch = str.charAt(0);
        if(ch == 'n' || ch == 'N') System.out.print("Naver D2");
        else System.out.print("Naver Whale");
    }
}
