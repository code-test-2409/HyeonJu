/**
 * 24. 11. 18.
 * [프로그래머스] 두 개 뽑아서 더하기
 */

package Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class pgms68644 {
    static class Solution {
        public int[] solution(int[] numbers) {
            Set<Integer> non_duplicate = new HashSet<>();

            for (int i = 0; i < numbers.length; i++) {
                for (int j = i+1; j < numbers.length; j++) {
                    int sum = numbers[i] + numbers[j];
                    non_duplicate.add(sum);
                }
            }

            int[] answer = non_duplicate.stream().mapToInt(Integer::intValue).toArray();

            Arrays.sort(answer);

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num_1 = {2,1,3,4,1};
        int[] num_2 = {5,0,2,7};

        System.out.println(Arrays.toString(s.solution(num_1)));
        System.out.println(Arrays.toString(s.solution(num_2)));

    }
}
