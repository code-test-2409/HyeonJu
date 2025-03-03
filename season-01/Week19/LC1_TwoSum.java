package Array;
import java.util.*;

/**
 * Grind 75
 * 1. Two Sum (45 ms / 45.36MB)
 *
 */

public class LC1_TwoSum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[] {i, j};
                    }
                }
            }
            return new int[] {};
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(nums, target)));
    }
}