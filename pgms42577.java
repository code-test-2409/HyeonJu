import java.util.Arrays;

/**
 *
 *  programmers 전화번호 목록 (https://school.programmers.co.kr/learn/courses/30/lessons/42577)
 *
 *  첫 번째 아이디어
 *  - phone_book을 HashSet()으로 만든다
 *  - 입력된 배열 원소로 HashSet() 탐색한다..
 *  - 탐색조건: 번호가 원소의 접두어인지 판별한다 startswith -> 그러면 answer를 false로 바꾼다.
 *  - 탐색 마치면 answer를 반환
 *
 *  이 아이디어 구현이 어려워서, 풀이를 참고함
 *
 */

public class pgms42577 {
    static class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Arrays.sort(phone_book); // 사전순 정렬
            for (int i = 0; i < phone_book.length-1; i++) {
                if (phone_book[i+1].startsWith(phone_book[i])) {
                    answer = false; // 순차탐색 하면서 접두어가 존재하면 바로 탈출
                    break;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};
        System.out.println(s.solution(phone_book));
    }

}
