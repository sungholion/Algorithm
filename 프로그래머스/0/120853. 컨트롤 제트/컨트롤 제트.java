import java.util.StringTokenizer;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(s, " ");
        int last = 0;
        
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            
            if (!token.equals("Z")) {
                last = Integer.parseInt(token); 
                answer += last;
            } else {
                answer -= last; 
            }
        }
        
        return answer;
    }
}