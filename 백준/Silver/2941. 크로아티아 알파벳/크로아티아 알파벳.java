import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        str = str.replace("c=", "*");
        str = str.replace("c-", "*");
        str = str.replace("dz=", "*");
        str = str.replace("d-", "*");
        str = str.replace("lj", "*");
        str = str.replace("nj", "*");
        str = str.replace("s=", "*");
        str = str.replace("z=", "*");

        System.out.println(str.length());
    }
}