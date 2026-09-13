package CommonQuestions;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        // check length first
        if (s.length() != t.length()) {
            return false;
        }
        // check the chars and their frequency
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        // last iteration to check if all the character's frequeuncy are zero at last or
        // not!
        for (int check : arr) {
            if (check != 0) {
                return false;
            }
        }
        return true;
    }
}