// 241029 [boj2869] 달팽이는 올라가고 싶다

package Maths;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2869 {

    static int A;
    static int B;
    static int V;
    static int result;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        System.out.println(calculateDays(A, B, V));
        
    }

    private static int calculateDays(int a, int b, int c) {
        c -= b;
        a -= b;
        if (c % a == 0) {
            result = c / a;
        } else
            result = c / a + 1;
        return result;
    }

}
