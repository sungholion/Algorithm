import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int N = scanner.nextInt();

        for(int i=0;i<N;i++){
            if(X%2==0){
                X=(X/2)^6;
            }else{
                X=(2*X)^6;
            }
        }

        System.out.println(X);
    }
}