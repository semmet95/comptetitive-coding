// https://www.hackerrank.com/challenges/one-month-preparation-kit-time-conversion/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=preparation-kits&playlist_slugs%5B%5D%5B%5D=one-month-preparation-kit&playlist_slugs%5B%5D%5B%5D=one-month-week-one&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimeConversion {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String date12 = br.readLine();

        DateFormat df12 = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat df24 = new SimpleDateFormat("HH:mm:ss");

        System.out.println(df24.format(df12.parse(date12)));
    }
}
