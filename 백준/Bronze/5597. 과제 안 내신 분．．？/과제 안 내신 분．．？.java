import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] submit = new int[31]; // 제출 여부 확인
        int n = 0; // 출석번호

        for ( int i = 0 ; i < 28 ; i++ ){
            n =  sc.nextInt();
            submit[n] = 1;
        }

        for (int i=1; i<=30; i++){
            if(submit[i] == 0){
                System.out.println(i);
            }
        }


    }
}
