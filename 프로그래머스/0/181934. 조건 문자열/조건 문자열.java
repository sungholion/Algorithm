class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        
        String op = ineq + eq;
        
        if(op.equals(">=")){
            answer = (n >= m) ? 1 : 0;
        } else if(op.equals("<=")){
            answer = (n <= m) ? 1 : 0;
        } else if(op.equals(">!")){
            answer = (n > m) ? 1 : 0;
        } else if(op.equals("<!")){
            answer = (n < m) ? 1 : 0;
        }
        
        return answer;
    }
}