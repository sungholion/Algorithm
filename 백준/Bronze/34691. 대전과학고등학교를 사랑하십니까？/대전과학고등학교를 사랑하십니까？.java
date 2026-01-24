import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s == null) break;      
            if (s.equals("end")) break;

            if (s.equals("animal")) sb.append("Panthera tigris\n");
            else if (s.equals("flower")) sb.append("Forsythia koreana\n");
            else if (s.equals("tree")) sb.append("Pinus densiflora\n");
        }

        System.out.print(sb.toString());
    }
}
