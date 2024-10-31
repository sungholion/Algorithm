class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        answer = new int[2];
        
        int cntConvert = 0;
        int cntZero = 0;
        while(!s.equals("1")){
            cntConvert++;
            String temp = "";
            for(int i=0; i<s.length(); i++){    // 0 제거
                if(s.charAt(i) == '0'){
                    cntZero++;
                } else{
                    temp += s.charAt(i);
                }
            }
            s = temp;
            
            int c = s.length();
            
            s = Integer.toBinaryString(c);
        
        }
        
        answer[0] = cntConvert;
        answer[1] = cntZero;
        
        return answer;
    }
}