import java.util.List;

public class SubArrayDiv1 {
    public static void main(String[] args) {
        
    }

    public static int birthday(List<Integer> s, int d, int m) {
        int left = 0, right = m - 1, ctr = 0, sum = 0, first = 0, last = 0;

        for(int i = 0; i < m; i++) sum += s.get(i);

        while(right < s.size()) {
            if(sum == d) ++ctr;
            ++right;

            first = s.get(left);
            last = s.get(right);
            sum = sum - first + last;
            ++left;
        }

        return ctr;
    }
}
