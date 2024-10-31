import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int l = A.length;
        
        for(int i=0; i<l; i++){
            answer += A[i] * B[l-1-i];
        }


        return answer;
    }
}