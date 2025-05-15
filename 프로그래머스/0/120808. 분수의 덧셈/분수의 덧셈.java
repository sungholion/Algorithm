class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        
        int comDenom = denom1 * denom2;
        int num = numer1 * denom2 + numer2 * denom1;
        int gcd = gcd(num, comDenom);
        
        answer = new int[]{num/gcd, comDenom/gcd};
        return answer;
    }
    
    public int gcd(int a, int b){
        while(b!=0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}