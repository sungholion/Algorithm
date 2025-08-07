class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        int[] charCnt1 = new int[26];
        int[] charCnt2 = new int[26];
        boolean isGap = false;
        
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            int cnt = -1;
            
            if (c == ' ') {
                if (!isGap) {
                    sb.append(c);
                    isGap = true;
                }
                continue;
            }
                
            
            if(Character.isLowerCase(c)){
                cnt = c - 'a';
                charCnt1[cnt]++;
                
                if(charCnt1[cnt] <=1)
                    sb.append(c);
            } else if(Character.isUpperCase(c)){
                cnt = c - 'A';
                charCnt2[cnt]++;
                
                if(charCnt2[cnt] <=1)
                    sb.append(c);
            }
            
            
        }
     return sb.toString(); 
    }
}