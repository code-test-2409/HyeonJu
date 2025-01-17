/**
 * 24. 11. 21.
 * [프로그래머스] 메뉴 리뉴얼
 * 테스트 케이스 통과, 정확성 65점 (100점)
 *
 * 25. 1. 9.
 * 리팩토링 후 통과
 */

package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pgms72411 {
    static class Solution {
        public String[] solution(String[] orders, int[] course) {
            List<String> answer = new ArrayList<>();

            // 주문 알파벳 정렬
            for (int i = 0; i < orders.length; i++) {
                char[] chars = orders[i].toCharArray(); // AB -> ['A', 'B']
                Arrays.sort(chars);
                orders[i] = new String(chars);
            }

            for(int courseSize : course) {
                Map<String, Integer> combinations = new HashMap<>();

                for (String order: orders) {
                    if (order.length() < courseSize) continue;
                    createCombinations(order, courseSize, 0, new StringBuilder(), combinations);
                }
                
                int maxCount = 0;
                for(int count: combinations.values()) {
                    maxCount = Math.max(maxCount, count);
                }

                for (Map.Entry<String, Integer> entry: combinations.entrySet()) {
                    if (entry.getValue() >= 2 && entry.getValue() == maxCount) {
                        answer.add(entry.getKey());
                    }
                }

            }

            return answer.stream().sorted().toArray(String[]::new); // 정렬 조건 추가하기..
        }

        private void createCombinations(String order, int courseSize, int start, StringBuilder combination,
                                        Map<String, Integer> map) {
            if (combination.length() == courseSize) {
                String result = combination.toString();
                map.put(result, map.getOrDefault(result, 0)+1);
                return;
            }

            for (int i = start; i < order.length(); i++) {
                combination.append(order.charAt(i));
                createCombinations(order, courseSize, i + 1, combination, map);
                combination.deleteCharAt(combination.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] orders_1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course_1 = {2, 3, 4};
        String[] result_1 = {"AC", "ACDE", "BCFG", "CDE"};

        String[] orders_2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course_2 = {2, 3, 5};
        String[] result_2 = {"ACD", "AD", "ADE", "CD", "XYZ"};

        String[] orders_3 = {"XYZ", "XWY", "WXA"};
        int[] course_3 = {2, 3, 4};
        String[] result_3 = {"WX", "XY"};

        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(orders_1, course_1)));
        System.out.println(Arrays.toString(s.solution(orders_2, course_2)));
        System.out.println(Arrays.toString(s.solution(orders_3, course_3)));
    }
}
