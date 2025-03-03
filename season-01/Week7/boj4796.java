/*
[BOJ4796] 캠핑
- 출력 형식에 주의해야 한다.
- 휴가 일수를 사용 가능 일수로 나눈 나머지 유무로 분기하니 틀림
- 휴가 일수를 사용 가능 일수로 나눈 나머지와 사용 가능일수를 비교하여 분기하니 정답
 */

package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj4796 {
    static int L;
    static int P;
    static int V;
    static int caseNo = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringBuffer answer = new StringBuffer("Case");
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken()); // 사용 가능 기간
            P = Integer.parseInt(st.nextToken()); // 연속 기간
            V = Integer.parseInt(st.nextToken()); // 휴가 기간
            if (L == 0 && P == 0 && V == 0) {
                break;
            }
            int num = calculateUse(L, P, V);
            System.out.println(answer.append(" ").append(caseNo).append(": ").append(num));
            caseNo ++;
        }
    }

    private static int calculateUse(int l, int p, int v) {
        if (v % p > l) {
            return (v / p) * l + l;
        } else {
            return (v / p) * l + (v % p);
        }
    }
}