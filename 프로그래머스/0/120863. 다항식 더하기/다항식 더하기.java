import java.util.*;
class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        StringTokenizer st = new StringTokenizer(polynomial, " ");
        
        int num = 0;
        int x_cnt = 0;
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            char c = temp.charAt(temp.length()-1);
            if(c == 'x'){
                if(temp.length() == 1){
                    x_cnt++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    for(int i=0; i<temp.length()-1; i++)
                        sb.append(temp.charAt(i));
                    x_cnt += Integer.parseInt(sb.toString());   
                }
            } else if(c == '+') {
               continue;
            } else {
                 num+= Integer.parseInt(temp);
            }
            
        }        
        
        if (x_cnt != 0) {
            answer += (x_cnt == 1 ? "x" : x_cnt + "x");
        }
        if (num != 0) {
            if (!answer.isEmpty()) answer += " + ";
            answer += num;
        }
        if (answer.isEmpty()) answer = "0";
        
        return answer;
    }
}