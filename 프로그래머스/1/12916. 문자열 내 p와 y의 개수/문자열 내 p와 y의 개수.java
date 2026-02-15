class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == 'p' || ch == 'P') pCnt++;
            if(ch == 'y' || ch == 'Y') yCnt++;
        }
        
        if(pCnt != yCnt) answer = false;

        return answer;
    }
}