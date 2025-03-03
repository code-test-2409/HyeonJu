/*
    [PROGRAMMERS-120911] 문자열 정렬하기(2)
    --- toLoserCase(), toCharArray(), new String() 사용법
*/
package String;

import java.util.Arrays;

public class pgms120911 {
    class Solution {
        public String solution(String my_string) {
            StringBuilder answer = new StringBuilder();

            char[] my_string_chars = my_string.toLowerCase().toCharArray();

            Arrays.sort(my_string_chars);
            for(char c: my_string_chars) {
                answer.append(c);
            }

            return answer.toString();
        }
    }
}
