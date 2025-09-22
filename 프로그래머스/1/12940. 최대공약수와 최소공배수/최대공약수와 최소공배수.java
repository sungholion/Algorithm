class Solution {
    public int[] solution(int n, int m) {
        if(n > m) return new int[]{getGcd(n, m), getLcm(n, m)};
        else return new int[]{getGcd(m, n), getLcm(m, n)};
    }
    
    static int getGcd(int a, int b){
        while(b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    
    static int getLcm(int a, int b){
        return (a * b) / getGcd(a, b);
    }
}