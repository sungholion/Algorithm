import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        char[] temp = s.toCharArray();
        Arrays.sort(temp);
        for(int i=temp.length-1; i>=0; i--)
            sb.append(temp[i]);
        
        return sb.toString();
    }
}