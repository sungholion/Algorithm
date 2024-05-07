import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static List<Long> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if(n <= 10){                    // 자릿수가 1일 때는, 0~9까지 총 9개 존재
            System.out.println(n);
            return;
        }
        else if(n > 1022){              // 0~9까지의 숫자로 10자리를 만들 수 있는 방법은
            System.out.println(-1);     // 2^10 = 1024 - 1(아무것도 뽑지않음) = 1023
            return;
        }
        else
        {
            for(int i = 0; i < 10; i++){
                bp(i);
            }

            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    static void bp(long num){
        list.add(num);

        for(int i=0; i<10; i++){
            if(num % 10 > i)
                bp(num*10 + i);
        }
    }

}