/**
 * 24. 11. 21.
 * [프로그래머스] Lv1. 문자열 내림차순으로 배치하기
 */

package Sort;

import java.util.Arrays;
import java.util.Comparator;

public class pgms12917 {
    static class Solution {
        public String solution(String s) {
            StringBuilder answer = new StringBuilder();
            String[] arr = s.split("");
            // Arrays.sort(arr, (a, b) -> b.compareTo(a));
            Arrays.sort(arr, Comparator.reverseOrder()); // 조금 더 속도가 빠르다.
            for(String a: arr) {
                answer.append(a);
            }

            return answer.toString();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("Zbcdefg"));
    }

}
