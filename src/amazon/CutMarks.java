// https://www.hackerearth.com/problem/algorithm/moving-to-new-office-dd532d09/

package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CutMarks {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            String[] inps = br.readLine().split(" ");
            int X = Integer.parseInt(inps[0]), Y = Integer.parseInt(inps[1]);
            
            int N = Integer.parseInt(br.readLine());
            Cut cuts[] = new Cut[N-2];
            int[] mPoints = new int[N];
            
            inps = br.readLine().split(" ");
            for(int i = 0; i < N; i++) mPoints[i] = Integer.parseInt(inps[i]);
            
            //set the cuts
            for(int i = 1; i < N-1; i++) cuts[i-1] = new Cut(mPoints[i], mPoints[0], mPoints[N-1]);
            
            //iterate over cuts till none remains
            while(isMarkUncut(cuts)) {
                int cutIndex = getMinCost(cuts, X, Y);
                
                updateCuts(cuts, cutIndex, X, Y);
            }
            
            long totalMinCost = 0;
            for(Cut cut: cuts) totalMinCost += cut.minCost;
            
            System.out.println(totalMinCost);
        }
    }
    
    private static boolean isMarkUncut(Cut[] cuts) {
        
        for(Cut cut: cuts) if(cut.minCost == -1) return true;
        
        return false;
    }
    
    private static int getMinCost(Cut[] cuts, int X, int Y) {
        long minCost = Long.MAX_VALUE;
        int cutIndex = -1;
        
        // iterate over each cut mark, get costs and return index of the cut with the minimum cost
        // make sure the mark is not already cut
        for(int i=0; i < cuts.length; i++) {
            Cut cut = cuts[i];
            
            if(cut.minCost == -1 && cut.getCost(X, Y) < minCost) {
                minCost = cut.getCost(X, Y);
                cutIndex = i;
            }
        }
        
        return cutIndex;
    }
    
    private static void updateCuts(Cut[] cuts, int cutIndex, int X, int Y) {
        // called everytime a cut is performed and returns updated totalMinCost
        long cutAtMark = cuts[cutIndex].mark;
        
        for(Cut cut: cuts) cut.setCut(cutAtMark, X, Y);
    }
    
    private static class Cut {
        
        long lMark, rMark, mark, minCost;

        Cut(int m, int lm, int rm) {
            
            mark = m;
            lMark = lm;
            rMark = rm;
            minCost = -1;
        }
        
        long getCost(int X, int Y) {
            
            return (minCost == -1) ? (mark - lMark) * X + (rMark - mark) * Y : minCost;
        }
        
        void setCut(long cutAtMark, int X, int Y) {
            
            if(cutAtMark < mark) lMark = cutAtMark;
            
            else if(cutAtMark > mark) rMark = cutAtMark;
            
            // this is the case when cut happens at this very mark
            else minCost = (mark - lMark) * X + (rMark - mark) * Y;
        }
    }
}
