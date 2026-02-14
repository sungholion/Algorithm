class Solution {
    public int solution(int a, int b) {
        String str1 = a + "" + b;
        int ab = Integer.parseInt(str1);
        String str2 = b + "" + a;
        int ba = Integer.parseInt(str2);
        
        return ab > ba ? ab : ba;
    }
}