class Solution {
    public int solution(int n) {
        String temp = Integer.toBinaryString(n);
        int len = 0;
        for(int i = 0; i<temp.length(); i++)
            if(temp.charAt(i) == '1') len++;
        
        int start = n + 1;
        while(start <= 1000000){
            temp = Integer.toBinaryString(start);
            int cnt = 0;
           for(int i = 0; i<temp.length(); i++)
                if(temp.charAt(i) == '1') cnt++;
            if(cnt == len){
                return start;
            }
            start++;
        }
        return start;
        
    }
}