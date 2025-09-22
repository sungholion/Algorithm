class Solution {
    public long solution(int price, int money, int count) {
        long moneyLong = money;
        for(int i=1; i<=count; i++)
            moneyLong -= (long)(price * i);
        if(moneyLong >= 0) return 0;
        else return moneyLong * -1;

    }
}