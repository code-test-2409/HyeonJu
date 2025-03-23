/***
 *   Date: 2025-03-17
 *   [프로그래머스] 모의고사
 */

import java.util.ArrayList;
import java.util.List;

public class pgms42840 {
    public int[] solution(int[] answers) {
        int problemCounts = answers.length; // 문제 개수

        int[] pattern_01 = {1, 2, 3, 4, 5};
        int[] pattern_02 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern_03 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[3];

        for(int i = 0; i < problemCounts; i++) {
            if (answers[i] == pattern_01[i % pattern_01.length]) answer[0] ++;
            if (answers[i] == pattern_02[i % pattern_02.length]) answer[1] ++;
            if (answers[i] == pattern_03[i % pattern_03.length]) answer[2] ++;
        }

        int maxScore = Math.max(answer[0], Math.max(answer[1], answer[2]));

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == maxScore) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
