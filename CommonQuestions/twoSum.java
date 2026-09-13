// https://leetcode.com/problems/two-sum/description/?utm_source=chatgpt.com

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> lookupMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // check if its complement exists in the hashmap
            if (lookupMap.get(target - nums[i]) != null) {
                return new int[] { i, lookupMap.get(target - nums[i]) };
            }

            // if not exists then add and move further!
            lookupMap.put(nums[i], i);

        }

        return new int[] { -1, -1 };
    }
}