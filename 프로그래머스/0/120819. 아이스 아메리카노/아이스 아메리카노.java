class Solution {
    public int[] solution(int money) {
        int q = money / 5500;
        int div = money % 5500;
        return new int[] {q, div};
    }
}