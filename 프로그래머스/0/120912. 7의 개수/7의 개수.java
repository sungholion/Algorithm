class Solution {
    public int solution(int[] array) {
        StringBuilder sb = new StringBuilder();
        for(int x : array)
            sb.append(x);
        
        String str = sb.toString();
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            int n = str.charAt(i) - '0';
            if(n == 7)
                cnt++;
        }
        return cnt;
        
    }
}