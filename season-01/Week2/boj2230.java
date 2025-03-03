import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  boj 수 고르기 (https://www.acmicpc.net/problem/2230)
 */
public class boj2230 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = Integer.MAX_VALUE;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /* 정렬 메서드 */
        Arrays.sort(arr);

        // int s = 0;
        int e = 0;

        for (int s = 0; s < n; s++) {
            while (e < n && arr[e] - arr[s] < m)
                e++;
            if (e == n) break;
            answer = min(answer, arr[e] - arr[s]);
        }

        System.out.println(answer);
    }
}
