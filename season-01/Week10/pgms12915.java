/**
 * 24. 11. 21.
 * [프로그래머스] 문자열 내 마음대로 정렬하기
 */

package Sort;

import java.util.Arrays;

public class pgms12915 {
    static class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (a, b) -> {
                if (a.charAt(n) - b.charAt(n) == 0) {
                    return a.compareTo(b);
                } else
                    return a.charAt(n) - b.charAt(n);
            });
            return strings;
        }


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] arr_1 = {"sun", "bed", "car"};
        int idx_1 = 1;
        String[] arr_2 = {"abce", "abcd", "cdx"};
        int idx_2 = 2;
        System.out.println(Arrays.toString(s.solution(arr_1, idx_1)));
        System.out.println(Arrays.toString(s.solution(arr_2, idx_2)));
    }
}
