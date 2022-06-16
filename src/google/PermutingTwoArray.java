import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PermutingTwoArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());
        while(q-- > 0) {
            String[] inps = br.readLine().split(" ");
            int n = Integer.parseInt(inps[0]), k = Integer.parseInt(inps[1]);

            List<Integer> A = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer> B = Stream.of(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            Collections.sort(A);
            Collections.sort(B);

            boolean res = true;

            for(int i = 0; i < n; i++) {
                if(A.get((n - 1) - i) + B.get(i) < k) {
                    res = false;
                    break;
                }
            }

            if(res) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
