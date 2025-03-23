/*
    DATE: 2025-03-21
    [BOJ-1946-SILVER-1] 신입 사원
    - Comparator.comparingInt()로 List 정렬
    - 두번째 정렬 기준인 면접시험 성적을 비교한다.
    - 이 때 서류 1등의 면접 등수보다 높은 지원자의 면접 등수로 갱신해주어야 한다.
    - 🚀메모리 307900 KB / ⌛️시간 2064 ms
 */

package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class boj1946 {
    public static class totalScore {
        int applicationRank;
        int interviewRank;

        public totalScore(int applicationRank, int interviewRank) {
            this.applicationRank = applicationRank;
            this.interviewRank = interviewRank;
        }

        @Override
        public String toString() {
            return "totalScore{" +
                "applicationRank=" + applicationRank +
                ", interviewRank=" + interviewRank +
                '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TestCase = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(TestCase > 0) {
            int applicants = Integer.parseInt(br.readLine());
            if (applicants == 1) {
                answer.append(1);
                break;
            }
            List<totalScore> scoreList = new ArrayList<>();

            /* 점수 입력 */
            for (int num = 0; num < applicants; num++) {
                String[] input = br.readLine().split(" ");
                scoreList.add(new totalScore(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
            }

            /* 오름차순 (등수이므로) */
            scoreList.sort(Comparator.comparing(score -> score.applicationRank));

            int minRank = scoreList.get(0).interviewRank; /* 1등의 면접 등수 */
            int passed = 0;

            for(totalScore score: scoreList) {
//                System.out.println("score = " + score.toString());
                if(score.applicationRank == 1) {
                    passed++;
                    System.out.println("score = " + score.toString() + "passed");
                    continue;
                }

                if (score.interviewRank < minRank) {
                    passed ++;
                    minRank = score.interviewRank;
                    System.out.println("score = " + score.toString() + "passed");
//                    System.out.println("passed");
                }
            }
            answer.append(passed).append("\n");
            TestCase--;
        }

        System.out.println(answer);
    }

}
