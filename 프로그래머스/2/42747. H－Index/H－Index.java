import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Integer[] arr = new Integer[citations.length];
        for(int i=0; i<citations.length; i++)
            arr[i] = citations[i];
        Arrays.sort(arr, Collections.reverseOrder());
        
        int h = 0;
        for(int i=0; i<arr.length; i++){
           int x = i + 1;
            if(arr[i] >= x) h = x;
            else break;
        }
        
        return h;
    }
}