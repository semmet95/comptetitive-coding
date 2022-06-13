// https://www.hackerrank.com/challenges/one-month-preparation-kit-diagonal-difference/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one&h_r=next-challenge&h_v=zen

import java.util.LinkedList;
import java.util.List;

public class DiagonalDifference {
    public static void main(String[] args) {
        List<List<Integer>> arr = new LinkedList<>();

        List<Integer> temp = new LinkedList<>();
        temp.add(1);
        temp.add(2);
        temp.add(3);
        arr.add(temp);

        temp = new LinkedList<>();
        temp.add(4);
        temp.add(5);
        temp.add(6);
        arr.add(temp);

        temp = new LinkedList<>();
        temp.add(9);
        temp.add(8);
        temp.add(9);
        arr.add(temp);

        

        int sum1=0, sum2=0;

        for(int i = 0; i < arr.size(); i++) {
            for(int j = 0; j < arr.size(); j++) {
                if(i == j) {
                    sum1 += arr.get(i).get(j);
                }
                if(i + j == arr.size() - 1) {
                    sum2 += arr.get(i).get(j);
                }
            }
        }

        System.out.println(Math.abs(sum1 - sum2));
    }
}
