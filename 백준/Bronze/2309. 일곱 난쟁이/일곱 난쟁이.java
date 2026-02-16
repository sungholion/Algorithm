import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] people = new int[9];
        int cur = 0;
        for(int i = 0; i < 9; i++) {
            people[i] = Integer.parseInt(br.readLine());
            cur += people[i];
        }
        Arrays.sort(people);

        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                if((cur - people[i] - people[j]) == 100){
                    for(int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;
                        System.out.println(people[k]);
                    }
                    return;
                }
            }
        }

    }
}
