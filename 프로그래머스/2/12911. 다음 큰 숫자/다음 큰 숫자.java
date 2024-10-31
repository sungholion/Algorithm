class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String nStr = Integer.toBinaryString(n);
        int nCnt = 0;
        for(int i=0; i<nStr.length(); i++){
            if(nStr.charAt(i) == '1'){
                nCnt++;
            }
        }
        // nStr = nStr.replaceAll("0", "");
        // int nLength = nStr.length();
    
        while(true){
            int temp = ++n;
            
            int tCnt = 0;
            String tStr = Integer.toBinaryString(temp);
            for(int i=0; i<tStr.length(); i++){
                if(tStr.charAt(i) == '1'){
                    tCnt++;
                }
            }
            // int tLength = tStr.length();
            
            if(tCnt == nCnt){
                answer = temp;
                break;
            }
            
        }
        
        return answer;
    }
}