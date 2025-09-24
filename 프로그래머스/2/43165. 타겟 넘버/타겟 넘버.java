class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    static void dfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(sum == target) answer++;
            return;   
        }
        dfs(numbers, target, depth+1, sum+numbers[depth]);
        dfs(numbers, target, depth+1, sum-numbers[depth]);
    }
    
}