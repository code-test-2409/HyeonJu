import java.util.*;

/***
 *   Date: 2025-03-10
 *   [프로그래머스] 구명보트
 */
public class pgms42885 {

    public static int solution(int[] people, int limit) {
        int answer = 0;
        int start = 0;
        int end = people.length - 1;

        Integer[] sortedPeople = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedPeople, Collections.reverseOrder()); // 내림차순 정렬

        while(start <= end) {
            if (sortedPeople[start] + sortedPeople[end] <= limit) {
                start ++;
                end --;
            } else {
                start ++;
            }
            answer ++;
        }
        return answer;
    }
}
