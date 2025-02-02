package Array;
import java.util.*;

/**
 * Two Sum
 */

public class LC1_TwoSum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] answer = new int[2];
            Arrays.fill(answer, -1);
            Map<Integer, Integer> num_map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                num_map.put(nums[i], i);
            }
            // num_map sort by value (ascending order)
            num_map.entrySet()
                   .stream()
                   .sorted(Map.Entry.comparingByValue());

            // target-num1 값과 비교하며 순회
            for (int num: num_map.keySet()) {
                int x = num;
                if (answer[0] == -1 && answer[1] == -1) {
                    answer[0] = num_map.get(num); // 인덱스
                } else break;
                int y = target - x; // 필요한 숫자
                for (int hubo: num_map.keySet()) {
                    if (hubo == x && answer[0] == num_map.get(hubo)) continue;
                    if (hubo == y) {
                        answer[1] = num_map.get(hubo);
                        break;
                    }
                }
                // 검증
            }
            System.out.println("num_map = " + num_map);
            System.out.println("answer = " + Arrays.toString(answer));
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        Solution s = new Solution();
        s.twoSum(nums, target);
        //System.out.println(s.twoSum(nums, target));
    }

}