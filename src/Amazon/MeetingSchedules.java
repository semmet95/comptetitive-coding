package hackerrrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MeetingSchedules {
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] inps = br.readLine().split(" ");
        int M = Integer.parseInt(inps[0]), K = Integer.parseInt(inps[1]);
        
        boolean[][] allBusy = new boolean[M][24 * 60];
        
        for(int i = 0; i < M; i++) {
            
            inps = br.readLine().split(" ");
            
            // get the start hh, start mm, end hh, end mm
            int sHH = Integer.parseInt(inps[0]), sMM = Integer.parseInt(inps[1]), 
                        eHH = Integer.parseInt(inps[2]), eMM = Integer.parseInt(inps[3]);
            
            // convert hh:mm format to minutes passed, set each value throught that range to true
            int sIdx = sHH * 60 + sMM, ePos = eHH * 60 + eMM;
            
            for(int min = sIdx; min < ePos; min++) allBusy[i][min] = true;
        }
        
        // traverse the matrix, minute by minute, check each joinee's availability
        for(int min = 0; min < 24 *60;) {
            
            int sMin = min, availableDuration;
            
            while(min < 24 * 60 && allAvailable(allBusy, min)) ++min;
            availableDuration = min - sMin;
            //System.out.println(availableDuration);
            
            if(availableDuration >= K) {
                
                int sHH = sMin / 60, sMM = sMin % 60, eHH = min / 60, eMM = min % 60;
                eHH %= 24;
                
                System.out.println(String.format("%02d %02d %02d %02d", sHH, sMM, eHH, eMM));
            }
            
            ++min;
        }
    }
    
    private static boolean allAvailable(boolean[][] allBusy, int minute) {
        
        for (boolean[] allBusy1 : allBusy) {
            if (allBusy1[minute]) {
                return false;
            }
        }
        
        return true;
    }
}