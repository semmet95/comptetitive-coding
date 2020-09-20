package hiringchallenges;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ListReduction {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inps = br.readLine().split(" ");
        int N = Integer.parseInt(inps[0]), K = Integer.parseInt(inps[1]);

        inps = br.readLine().split(" ");
        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(inps[i]);
        }
        Arrays.sort(arr);

        int ops = 0;
        while (ops++ < K) {

            int[] minMaxIdx = {0, N - 1};

            long minBefore = arr[minMaxIdx[0]], maxBefore = arr[minMaxIdx[1]], sumBefore = minBefore + maxBefore;

            // perform the operation
            arr[minMaxIdx[0]] *= 2;
            arr[minMaxIdx[1]] += 1;
            arr[minMaxIdx[1]] = (long) (arr[minMaxIdx[1]] / 2);

            long sumAfter = arr[minMaxIdx[0]] + arr[minMaxIdx[1]];

            if (sumAfter > sumBefore) {
                arr[minMaxIdx[0]] = minBefore;
                arr[minMaxIdx[1]] = maxBefore;
                break;
            }
            
            checkMinMaxIdx(arr);
        }

        long arrSum = 0;
        for (long ele : arr) {
            arrSum += ele;
        }

        System.out.println(arrSum);
    }

    private static void checkMinMaxIdx(long[] arr) {
        long minBefore = arr[0], maxBefore = arr[arr.length - 1], temp;

        for (int i = 1; i < arr.length && arr[i - 1] > arr[i]; i++) {
            temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }

        for (int i = arr.length - 1; i > 0 && arr[i - 1] > arr[i]; i--) {
            temp = arr[i - 1];
            arr[i - 1] = arr[i];
            arr[i] = temp;
        }
    }
}
