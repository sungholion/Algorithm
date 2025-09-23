class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = i;
        
        int left = 0, sum = 0;
        for(int right=1; right <arr.length;right++){
            sum += arr[right];
            
            while(sum > n && left <= right)
                sum -= arr[left++];
            
            if(sum == n) answer++;
        }
        
        return answer;
    }
}