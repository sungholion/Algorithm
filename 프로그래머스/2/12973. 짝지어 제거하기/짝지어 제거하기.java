import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        // 처음 문자열의 길이와 스택에 넣고 나서 문자열의 길이가 같으면 0
        // 다르면 계속 진행
        stack.push(s.charAt(0));
        
        for(int i=1; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && stack.peek() == ch)
               stack.pop();
            else stack.push(ch);
        }
        
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}