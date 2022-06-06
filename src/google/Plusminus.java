// https://www.hackerrank.com/challenges/one-month-preparation-kit-plus-minus/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-month-week-one

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Plusminus {
    static int posCount, negCount, zeroCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float n = Integer.parseInt(br.readLine());
        
        posCount = negCount = zeroCount = 0;

        Arrays.stream(br.readLine()
            .split(" ")).
            forEach(element -> {
                int num = Integer.parseInt(element);

                if(num > 0) {
                    ++posCount;
                }
                else if(num < 0) {
                    ++negCount;
                }
                else {
                    ++zeroCount;
                }
            });

        out.printf("%.6f%n%.6f%n%.6f%n", (posCount/n), (negCount/n), (zeroCount/n));
    }
}