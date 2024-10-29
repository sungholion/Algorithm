import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int div = 1;
        
        while(true){
            answer += ((n%(div*10))/div);
            div*= 10;
            if(div > n){
                break;
            }
        }

        return answer;
    }
}