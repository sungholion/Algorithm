import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        sb.append(":fan::fan::fan:\n");
        sb.append(":fan::" + str + "::fan:\n");
        sb.append(":fan::fan::fan:\n");

        System.out.print(sb.toString());
    }
}
