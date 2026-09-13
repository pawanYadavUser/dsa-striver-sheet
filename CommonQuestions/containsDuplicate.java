package CommonQuestions;

// https://leetcode.com/problems/contains-duplicate/description/?utm_source=chatgpt.com
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // check if element already present in the lookup map
            if (lookup.get(nums[i]) != null) {
                return true;
            } else {
                // insert the element in the lookup table
                lookup.put(nums[i], i);
            }

        }

        return false;
    }
}