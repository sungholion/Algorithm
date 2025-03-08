class Solution {
    public int solution(int n, int t) {
        int answer = 0;
        double tot = n * Math.pow(2, t);
        answer = (int) tot;
        return answer;
    }
}