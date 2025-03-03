/*
    [PROGRAMMERS-120904] 숫자 찾기
    --- String.indexOf() 메서드 사용 문제
*/
package String;

public class pgms120904 {
    class Solution {
        public int solution(int num, int k) {
            char[] c_arr = String.valueOf(num).toCharArray();
            for(int i = 0; i < c_arr.length; i++) {
                if (Character.getNumericValue(c_arr[i]) == k) return i + 1;
            }
            return -1;
        }
    }
}