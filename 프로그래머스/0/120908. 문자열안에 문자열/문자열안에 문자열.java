class Solution {
    public int solution(String str1, String str2) {
        char str2_p = str2.charAt(0);
        
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.charAt(i) == str2_p) {
                boolean same = true;
                for (int j = 0; j < str2.length(); j++) {
                    if (str1.charAt(i + j) != str2.charAt(j)) {
                        same = false;
                        break;
                    }
                }
                if (same)
                    return 1;
            }
        }
        return 2;
    }
}
