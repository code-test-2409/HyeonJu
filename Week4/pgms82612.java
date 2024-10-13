
    /*
     *  pgms 부족한 금액 계산하기 (https://school.programmers.co.kr/learn/courses/30/lessons/82612)
     *  1 try- test case 18~22 실패
     *  2 try- input을 long으로 받으니 실패 없이 통과
     * */

    public class pgms82612 {
    static class Solution {
        public long solution(long price, long money, long count) {
            long answer = -1;
            long totalCost = ((count + 1) * price * count) / 2;

            if (money - totalCost < 0) {
                answer = Math.abs(money - totalCost);
            } else {
                answer = 0;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2500, 4, 2500));
    }

}
