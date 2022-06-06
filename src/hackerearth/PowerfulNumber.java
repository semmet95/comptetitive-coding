import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class PowerfulNumber {
    public static void main(String args[]) throws Exception{

        var br = new BufferedReader(new InputStreamReader(System.in));
        var wr = new PrintWriter(System.out);

        int[] allSums = {1,2,4,8,7,5};
        var T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            var N = Integer.parseInt(br.readLine());
            wr.println(allSums[N%6]);
        }

        br.close();
        wr.close();
    }

}