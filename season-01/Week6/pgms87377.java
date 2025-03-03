// 241026 최종해결 programmers 교점에 별 만들기 [https://school.programmers.co.kr/learn/courses/30/lessons/87377]

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class pgms87377 {
    private static class Solution {
        public String[] solution(int[][] line) {
            Set<String> crossedIdx = new HashSet<>(); // 교차점 HashSet

            int lineArrSize = line.length;

            for (int i = 0; i < lineArrSize; i++) {
                for (int j = i+1; j < lineArrSize; j++) {
                    int[] first = line[i]; // 첫번째 직선
                    int[] second = line[j]; // 두번째 직선

                    long A = first[0]; long B = first[1]; long E = first[2];
                    long C = second[0]; long D = second[1]; long F = second[2];

                    long denominator = A*D - B*C; // 분모

                    if (denominator == 0) {
                        continue;
                    }

                    long xNumerator = B*F - E*D;
                    long yNumerator = E*C - A*F;

                    if (xNumerator % denominator == 0 && yNumerator % denominator == 0) {
                        long x = xNumerator / denominator;
                        long y = yNumerator / denominator;
                        crossedIdx.add(x + "," + y);
                    }
                }
            }

            long maxX = Integer.MIN_VALUE; long maxY = Integer.MIN_VALUE;
            long minX = Integer.MAX_VALUE; long minY = Integer.MAX_VALUE;

            for (String point: crossedIdx) {
                String[] coords = point.split(",");
                long x = Integer.parseInt(coords[0]);
                long y = Integer.parseInt(coords[1]);

                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
            }

            // 별과 점으로 그림 그리기
            int width = (int) (maxX - minX + 1);
            int height = (int) (maxY - minY + 1);

            char[][] grid = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = '.';
                }
            }

            for (String point: crossedIdx) {
                String[] coords = point.split(",");
                long x = Long.parseLong(coords[0]);
                long y = Long.parseLong(coords[1]);
                grid[(int)(maxY - y)][(int)(x - minX)] = '*'; // 좌표 변환
            }

            String[] answer = new String[height];
            for (int i = 0; i < height; i++) {
                answer[i] = new String(grid[i]);
            }

            return answer;
        }

    }

    // BigInteger로 오버플로우가 나지 않도록 리팩토링한 버전
    public String[] solution_bigInt(int[][] line) {
        Set<String> crossedIdx = new HashSet<>();
        int lineArrSize = line.length;

        for (int i = 0; i < lineArrSize; i++) {
            for (int j = i + 1; j < lineArrSize; j++) {
                int[] first = line[i];
                int[] second = line[j];

                BigInteger A = BigInteger.valueOf(first[0]);
                BigInteger B = BigInteger.valueOf(first[1]);
                BigInteger E = BigInteger.valueOf(first[2]);
                BigInteger C = BigInteger.valueOf(second[0]);
                BigInteger D = BigInteger.valueOf(second[1]);
                BigInteger F = BigInteger.valueOf(second[2]);

                BigInteger denominator = A.multiply(D).subtract(B.multiply(C));

                if (denominator.equals(BigInteger.ZERO)) {
                    continue; // 평행한 직선은 교점이 없음
                }

                BigInteger xNumerator = B.multiply(F).subtract(E.multiply(D));
                BigInteger yNumerator = E.multiply(C).subtract(A.multiply(F));

                if (xNumerator.remainder(denominator.abs()).equals(BigInteger.ZERO) &&
                    yNumerator.remainder(denominator.abs()).equals(BigInteger.ZERO)) {

                    BigInteger x = xNumerator.divide(denominator);
                    BigInteger y = yNumerator.divide(denominator);
                    crossedIdx.add(x + "," + y);
                }
            }
        }

        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;

        for (String point : crossedIdx) {
            String[] coords = point.split(",");
            long x = Long.parseLong(coords[0]);
            long y = Long.parseLong(coords[1]);

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
            minX = Math.min(minX, x);
            minY = Math.min(minY, y);
        }

        int width = (int) (maxX - minX + 1);
        int height = (int) (maxY - minY + 1);

        char[][] grid = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = '.';
            }
        }

        for (String point : crossedIdx) {
            String[] coords = point.split(",");
            long x = Long.parseLong(coords[0]);
            long y = Long.parseLong(coords[1]);
            grid[(int) (maxY - y)][(int) (x - minX)] = '*';
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = new String(grid[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
         int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
//        int[][] line = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        solution.solution(line);
    }
}