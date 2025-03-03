/**
 * 24. 11. 21.
 * [프로그래머스] 가장 큰 수
 * BigInteger를 사용하지 않아도 괜찮은지 궁금하다..!
 * -> 배열 최대길이, 원소 최대값 조건을 반대로 봤다.
 * -> 책의 풀이를 참고했다.
 */

package Sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class pgms42746 {

    static class Solution {
        public String solution(int[] numbers) {

            return Arrays.stream(numbers)
                  .mapToObj(String::valueOf)
                  .sorted((s1, s2) -> {
                     int original = Integer.parseInt(s1.concat(s2));
                     int reversed = Integer.parseInt(s2.concat(s1));
                     return reversed - original;
                     // 양수이면 s1이 뒤로, 음수이면 s2가 뒤로..
                  })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0"); // 0 여러개는 0 하나로 바꾸어서 반환
            // return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] number_a = {6, 10, 2};
        int[] number_b = {3, 30, 34, 5, 9};

        System.out.println(s.solution(number_a));
        System.out.println(s.solution(number_b));
    }
}