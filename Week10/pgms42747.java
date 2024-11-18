/**
 * 24. 11. 18.
 * [프로그래머스] H-Index
 * 책 풀이 참고
 */

package Sort;

import java.util.Arrays;

public class pgms42747 {
    static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);

            for (int h = citations.length; h >= 1; h--) {
                if (isValid(citations, h)) return h;
            }

            return 0;
        }

        private boolean isValid(int[] citations, int h) {
            int idx = citations.length - h;
            return citations[idx] >= h;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] citations = {3, 0, 6, 1, 5};
        // int[] citations = {2, 4, 6, 8, 10};

        System.out.println(s.solution(citations));
    }
}
