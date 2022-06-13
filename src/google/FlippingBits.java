// https://www.hackerrank.com/challenges/one-month-preparation-kit-flipping-bits/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=preparation-kits&playlist_slugs%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D=one-month-week-one

public class FlippingBits {
    public static void main(String[] args) {
        long num = 9;
        long flipper = (long) (Math.pow(2, 32) - 1);

        long res = num ^ flipper;
        System.out.println(res);
    }
}
