import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int ask(String target) throws Exception {
        for (int i = 1; i <= 9; i++) {
            System.out.println("? " + target + " " + i);
            System.out.flush(); 

            int res = Integer.parseInt(br.readLine().trim());
            if (res == 1) return i;
        }
        return -1; 
    }

    public static void main(String[] args) throws Exception {
        int A = ask("A");
        int B = ask("B");

        System.out.println("! " + (A + B));
        System.out.flush();
    }
}
