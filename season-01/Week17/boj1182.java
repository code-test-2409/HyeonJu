/**
 *  [250116] 부분수열의 합 https://www.acmicpc.net/problem/1182
 *  DFS, 백트래킹, 재귀.
 *  [Resource] 14204 KB / 120 ms
 *
 *  N개 정수로 이루어진 수열
 *  크기가 양수인 부분수열 중 수열 원소를 다 더한 값이 S가 되는 경우의 수
 *  N = 5, S = 0
 *  -7, -3, -2, 5, 8
 *
 *  백트래킹 탈출 조건- 합이 0이 될 때
 *
 *  2차원 배열을 만들고 -1로 초기화한다..
 *      -7  -3   -2    5   8
 *  -7  -7  -10  -9    -4  4
 *  -3 null -3   -5    0   8
 *  -2 null null -2    3   11
 *  5  null null null  5   13
 *  8  null null null null  8
 *  -> 구현 못하겠다
 *
 *  N = 5
 *  S = 0
 *  -7, -3, -2, 5, 8
 *
 *  arraySum = 0
 * arraySum = -7
 * backTracking(array, target 0, start + 1 = 1, arraySum = -7);
 *  ->arraySum = -7 + -3 = -10
 *  ->backTracking(array, target 0, start + 1 = 2, arraySum = -10);
 *      ->arraySum = -10 + -2 = -12
 *          ->backTracking(array, target 0, start + 1 = 3, arraySum = -12);
 *          -> arraySum = -12 + 5 = -7
 *              ->backTracking(array, target 0, start + 1 = 4, arraySum = -7);
 *
 *                  -> arraySum = -7 + 8 = 1 (더 이상 뒤에 더할 원소 X) [return]
*               -> arraySum = 0;
 */

package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182 {
    static int answer;
    static int[] array;
    static int N, S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;

        // int arraySum = 0;
        // backTracking(arr, S, 0, arraySum);

        backTracking(0, 0);

        if (S == 0) answer --;

        System.out.println(answer);

    }

    static void backTracking(int currentIdx, int subTotal){
        if (currentIdx == N) {
            if (subTotal == S) answer++;
            return;
        }

        backTracking(currentIdx+1, subTotal); //원소를 더하지 않은 경우
        backTracking(currentIdx+1, subTotal + array[currentIdx]); //원소를 더하지 않은 경우
    }

}
