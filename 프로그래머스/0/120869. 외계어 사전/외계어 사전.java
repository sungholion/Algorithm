import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        String target = sortChars(String.join("", spell)); // spell 문자들을 합쳐 정렬

        for (String w : dic) {
            if (w.length() == spell.length && sortChars(w).equals(target)) {
                return 1;
            }
        }
        return 2;
    }

    private String sortChars(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}