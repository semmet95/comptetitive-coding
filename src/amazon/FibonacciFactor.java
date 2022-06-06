// https://www.hackerrank.com/contests/amazon/challenges/fibonacci-factor

package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class FibonacciFactor {

    private static HashMap<Long, Long> fibCache = new HashMap<>();

    public static void main(String args[]) throws Exception {

        fibCache.put(1l, 2l);
        fibCache.put(2l, 3l);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        outer: while(T-- > 0) {

            int K = Integer.parseInt(br.readLine());
            HashSet<Integer> primeFactors = getPrimeFactors(K);
            long currFib = 1, lastFib = 1;

            while(true) {

                long F = getNextFib(currFib, lastFib);
                lastFib = currFib;
                currFib = F;

                for(int factor: primeFactors) {

                    if(factor > (K + F)) break;

                    if((K + F) % factor == 0) {

                        System.out.println(F + " " + factor);
                        continue outer;
                    }
                }
            }
        }
    }

    private static HashSet<Integer> getPrimeFactors(int num) {

        HashSet<Integer> primeFactors = new HashSet<>();

        for (int i = 2; i <= num; i++) {

            while(num % i == 0) {

                primeFactors.add(i);
                num /= i;
            }
        }

        return primeFactors;
    }

    private static long getNextFib(long currFib, long lastFib) {

        if(!fibCache.containsKey(currFib)) fibCache.put(currFib, currFib + lastFib);

        return fibCache.get(currFib);
    }
}
