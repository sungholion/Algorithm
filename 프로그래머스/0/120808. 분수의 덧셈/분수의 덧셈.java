class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
       int numer3 = (numer1 * denom2) + (numer2 * denom1);
       int denom3 = denom1 * denom2;
        
       int gcd = getGCD(numer3, denom3);
    
       return new int[] {numer3 / gcd, denom3 / gcd};
    }
    
    private int getGCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
  
}