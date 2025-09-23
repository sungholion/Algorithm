class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int zero = 0;
        
        while(true){
            if(s.equals("1")) break;
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);
                if(ch == '0') zero++;
                else sb.append(ch);
            }
            int c = sb.length();
            s = Integer.toBinaryString(c);
            cnt++;
        }
        return new int[]{cnt, zero};
    }
}