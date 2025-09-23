import java.util.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            if(temp.equals(" ")){
                sb.append(" ");
                continue;
            }
            sb.append(Character.toUpperCase(temp.charAt(0)));
            if(temp.length() > 1)
                sb.append(temp.substring(1).toLowerCase());
        }
        return sb.toString();
    }
}