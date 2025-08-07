import java.util.*;

class Solution {
    public String solution(String my_string) {
        char[] str = my_string.toCharArray();
        for(int i=0; i<str.length; i++){
            if(Character.isUpperCase(str[i]))
                str[i] = Character.toLowerCase(str[i]);
        }
        Arrays.sort(str);
        
        return new String(str);
        
    }
}