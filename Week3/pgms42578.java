import java.util.HashMap;
import java.util.Map;

/**
 *  programmers 의상 (https://school.programmers.co.kr/learn/courses/30/lessons/42578)
 *  HashMap 사용하여 풀이
 *  key별 value값으로 정답 구하는 로직에서 틀려서 다른 사람의 풀이 참고
 */

public class pgms42578 {
    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;

            // String: Category Name, Integer: num of clothes
            Map<String, Integer> closet = new HashMap<>();

            for (String[] pair: clothes) {
                String category = pair[1]; // closet's key
                closet.put(category, closet.getOrDefault(category, 0) + 1);
            }

            if (closet.size() == 1) {
                answer = closet.values().iterator().next();
            } else {
                int product = 1;

                for (int value: closet.values()) {
                    product *= (value + 1);
                }

                answer = product - 1;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] clothes = new String[][]{{"crow_mask", "face"},
                                            {"blue_sunglasses", "face"},
                                            {"smoky_makeup", "face"}};
        System.out.println(s.solution(clothes));
    }

}
