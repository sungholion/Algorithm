class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int cntP = 0, cntY = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'p' || ch == 'P') cntP++;
            if(ch == 'y' || ch == 'Y') cntY++;
        }
        answer = cntP == cntY ? true : false;
        return answer;
    }
}