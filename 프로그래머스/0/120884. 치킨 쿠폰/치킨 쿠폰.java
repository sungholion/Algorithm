class Solution {
    public int solution(int chicken) {
        int coupon = chicken;
        int result = 0;
        
        while(coupon > 9){
            result += coupon / 10;
            coupon = (coupon / 10) + (coupon % 10);
        }
        
        return result;
    }
}