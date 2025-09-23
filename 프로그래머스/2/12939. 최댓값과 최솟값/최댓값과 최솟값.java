import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(num < min)
                min = num;
            if(num > max)
                max = num;
        }
        return (min + " " + max);
    }
}