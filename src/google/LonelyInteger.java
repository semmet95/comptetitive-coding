// https://www.hackerrank.com/challenges/one-month-preparation-kit-flipping-bits/problem?h_l=interview&h_r=next-challenge&h_v=zen&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-month-week-one

import java.util.Arrays;
import java.util.List;

class LonelyInteger {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,3,2,1};
        List<Integer> a = Arrays.asList(arr);
        int[] freqs = new int[101];

        a.forEach(ele -> freqs[ele] += 1);
        
        for(int i = 0; i < freqs.length; i++) {
            if(freqs[i] == 1) {
                System.out.println(i);
                break;
            }
        }
    }
}