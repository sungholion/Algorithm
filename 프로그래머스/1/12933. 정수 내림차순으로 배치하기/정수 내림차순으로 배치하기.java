class Solution {
    public long solution(long n) {
        long[] cnt = new long[10];
        while(n != 0){
            long x = n % 10;
            cnt[(int)x]+= 1;
            n /= 10;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--){
            while(cnt[i] > 0){
                sb.append(i);
                cnt[i]--;
            }
        }
        
        return Long.parseLong(sb.toString());
    }
}