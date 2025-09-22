import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // 2개의 배열로 분할하기
        // 한쪽에 가로 세로 중 긴 거 몰아넣기
        // 한쪽에 남은 건 작은 것 중에 제일 큰 것
        int answer = 0;
        
        int[] arr1 = new int[sizes.length];
        int[] arr2 = new int[sizes.length];
        
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] > sizes[i][1]){
                arr1[i] = sizes[i][0];
                arr2[i] = sizes[i][1];
            } else {
                arr1[i] = sizes[i][1];
                arr2[i] = sizes[i][0];
            }
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        answer = arr1[sizes.length-1] * arr2[sizes.length-1];
        
        return answer;
    }
}