class Solution {
    public int solution(int num) {
        long x = num;
        if(x == 1) return 0;
        int cnt = 0;
        while(x != 1){
            if((x % 2) == 0) x /= 2;
            else x = (x * 3) + 1;
            cnt++;
            if(cnt == 500) return -1;
        }
        
        return cnt;
    }
}