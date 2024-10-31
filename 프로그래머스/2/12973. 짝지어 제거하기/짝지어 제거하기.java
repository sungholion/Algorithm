import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        
        String[] str = s.split("");
        Stack<String> stack = new Stack<>();
        
        for(String alpa : str){
            if(!stack.isEmpty() && alpa.equals(stack.peek())){
                stack.pop();
            } else {
                stack.push(alpa);
            }
        }
        
        if(stack.isEmpty()){
            answer = 1;
        } else {
            answer = 0;
        }
        
        return answer;
    }
}