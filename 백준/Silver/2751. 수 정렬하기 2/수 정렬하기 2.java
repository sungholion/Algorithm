import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> lst = new ArrayList<>();

        for(int i=0; i<n; i++)
            lst.add(Integer.parseInt(br.readLine()));

        Collections.sort(lst);

        for(int i : lst)
            bw.write(i+"\n");

        bw.flush();
        bw.close();
        br.close();

    }
}
