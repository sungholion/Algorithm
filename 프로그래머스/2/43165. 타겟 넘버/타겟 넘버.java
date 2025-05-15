class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers, target, 0, 0);
        answer = cnt;
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int depth, int sum){
        if(depth == numbers.length){
            if(sum == target)
                cnt++;
            return;
        }
        dfs(numbers, target, depth+1, sum + numbers[depth]);
        dfs(numbers, target, depth+1, sum - numbers[depth]);
    }
    

}