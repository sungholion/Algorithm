import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        int add = sc.nextInt();

        m += add;
        if ((m+add) >= 60){
            h+= m/60;
            m-= (m/60)*60;
        }
        else
            m+=add;

        if(h >= 24)
            h-= 24;

        System.out.println(h + " " + m);


    }
}
