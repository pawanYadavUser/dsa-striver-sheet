package CommonQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ans = new HashMap<>();

        for (String str : strs) {
            // create alphabet array for given string unique char value
            int[] letters = new int[26];

            // char array from string
            char[] charArr = str.toCharArray();

            // iterate over char arr and update the letters arr for unique key
            for (char ch : charArr) {
                letters[ch - 'a']++;
            }

            // create the unique string key
            StringBuilder sb = new StringBuilder();
            // append all the letter indices value for unique key string creation
            for (int indexVal : letters) {
                sb.append(indexVal).append("#");
            }
            String key = sb.toString();
            // check if this unique key exist already in the ans map

            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);

        }

        return new ArrayList<>(ans.values());

    }
}