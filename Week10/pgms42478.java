/**
 * 24. 11. 18.
 * [프로그래머스] K번째수
 */

package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pgms42478 {
// commands는 1부터 시작하는 수
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = {};
            List<Integer> number_Kth = new ArrayList<>();
            for (int[] command: commands) {
                int i = command[0] - 1; // 2 -> 1
                int j = command[1] - 1; // 5 -> 4
                int k = command[2] - 1; // 3 -> 2
                int[] copied = Arrays.copyOfRange(array, i, j+1);
                Arrays.sort(copied);
                number_Kth.add(copied[k]);
            }

            return number_Kth.stream().mapToInt(Integer::intValue).toArray();
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
            {2, 5, 3},
            {4, 4, 1},
            {1, 7, 3}
        };
        System.out.println(Arrays.toString(s.solution(array, commands)));
    }
}