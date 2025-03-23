/*
    DATE: 2025-03-21
    [BOJ-1157-BRONZE-1] 단어 공부
    - 입력 받은 단어를 순회하며 알파벳을 기록 (HashMap), 최대값을 기록
    - 맵을 순회하며 최대값을 가지는 알파벳을 key(글자), value(갯수)로 세어 List에 저장
    - List 원소 개수가 1개라면 value를, 그 외의 경우 ?를 출력
    - 🚀메모리 36772 KB / ⌛️시간 332 ms
 */

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class boj1157 {

    static int maxValue = -1;
    static char variousAnswer = '?';


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase(Locale.ROOT);
        // int maxValue = -1;
        // char variousAnswer = '?';
        solution_1 s = new solution_1();
        solution_2 s2 = new solution_2();
        System.out.println(s.solution(input));
        System.out.println(s2.solution(input));
    }

    public static class solution_1 {
        public static char solution(String input) {
            Map<Character, Integer> charCount = new HashMap<>();
            List<pair> pairList = new ArrayList<>();

            for (int i = 0; i < input.length(); i++) {
                Character c = input.charAt(i);
                int updatedCount = charCount.getOrDefault(c, 0) + 1;
                charCount.put(c, updatedCount);
                maxValue = Math.max(maxValue, updatedCount);
            }

            for (Character c: charCount.keySet()) {
                if (charCount.get(c) == maxValue) {
                    pairList.add(new pair(c.charValue(), charCount.get(c)));
                }
            }

            if (pairList.size() == 1) {
                return pairList.get(0).c;
            } else {
                return variousAnswer;
            }
        }

        static class pair {
            char c;
            int value;

            public pair(char c, int value) {
                this.c = c;
                this.value = value;
            }
        }
    }

    static class solution_2 {
        public static char solution(String input) {
            int[] array = new int[26];
            char answer = 0;

            /* 알파벳 개수 세기 */
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                array[c - 65] += 1;
                maxValue = Math.max(maxValue, array[c - 65]);
            }

            int maxValueCnt = 0;
            for(int i = 0; i < 26; i++) {
                if (array[i] == maxValue) {
                    maxValueCnt++;
                    answer = (char)(i+65);
                }
            }

            if (maxValueCnt == 1) {
                return answer;
            } else {
                return variousAnswer;
            }
        }
    }
}
