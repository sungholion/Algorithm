import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        if (n >= 620 && n <= 780) {
            System.out.println("Red");
        } else if (n >= 590) {
            System.out.println("Orange");
        } else if (n >= 570) {
            System.out.println("Yellow");
        } else if (n >= 495) {
            System.out.println("Green");
        } else if (n >= 450) {
            System.out.println("Blue");
        } else if (n >= 425) {
            System.out.println("Indigo");
        } else {
            System.out.println("Violet");
        }
    }
}