package BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
*  boj 로또 https://www.acmicpc.net/problem/6603
*  풀이 참고
* */

public class boj6603 {

    static int[] S;
    static int[] combination;
    static int k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;

            S = new int[k];
            combination = new int[6];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            generateCombinations(0, 0);
            System.out.println();
        }

    }

    private static void generateCombinations(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                System.out.print(combination[i]+ " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < k; i++) {
            combination[depth] = S[i];
            generateCombinations(i + 1, depth + 1);
        }
    }

}
