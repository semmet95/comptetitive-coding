package hackerrrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ShortestSubSegment {
    public static void main(String args[]) throws Exception {
        HashMap<String, Integer> allWordsIndices = new HashMap<>();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                
        String inpParagraph = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < k; i++)
            allWordsIndices.put(br.readLine().toLowerCase(), -1);
        
        // tokenize the input string
        //inpParagraph = inpParagraph.toLowerCase();
        String[] inpWords = inpParagraph.split(" ");
        
        // clean up every word
        for(int i = 0; i < inpWords.length; i++)
            inpWords[i] = inpWords[i].replaceAll("[^a-zA-Z\\s]", "").trim();
        
        int minLength = Integer.MAX_VALUE;
        int[] finalIndices = new int[allWordsIndices.size()];
        
        for(int i = 0; i < inpWords.length; i++) {
            if(allWordsIndices.containsKey(inpWords[i].toLowerCase())) {
                int currIndex = allWordsIndices.get(inpWords[i].toLowerCase());
                
                // update the word's index as i
                // check if all words have been encountered, if yes, get the length of the segment and if its bigger
                // than current minLength, revert the index back to the original value, else set the finalIndices
                allWordsIndices.put(inpWords[i].toLowerCase(), i);
                
                if(allWordsChecked(allWordsIndices)) {
                    int segmentLength = getSegmentLength(allWordsIndices);
                    
                    if(segmentLength < minLength) {
                        minLength = segmentLength;
                        
                        int j = 0;
                        for(Object index: allWordsIndices.values()) {
                            finalIndices[j++] = (int)index;
                        }
                    } //else allWordsIndices.put(inpWords[i].toLowerCase(), currIndex);
                }
            }
        }
        
        if(!allWordsChecked(allWordsIndices))
            System.out.println("NO SUBSEGMENT FOUND");
        
        else {
            int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;

            for(int index: finalIndices) {
                if(index < minIndex) {
                    minIndex = index;
                }
                
                if(index > maxIndex) {
                    maxIndex = index;
                }
            }
            
            for(int i = minIndex; i <= maxIndex; i++)
                System.out.print(inpWords[i] + " ");
        }     
    }
    
    private static int getSegmentLength(HashMap allWordsIndices) {
        if(!allWordsChecked(allWordsIndices)) { return -1; }
        
        int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;
        
        for(Object value: allWordsIndices.values()) {
            int index = (int)value;
                        
            if(index < minIndex)
                minIndex = index;
                        
            if(index > maxIndex)
                maxIndex = index;
        }
        
        return maxIndex - minIndex + 1;
    }
    
    private static boolean allWordsChecked(HashMap allWordsIndices) {
        
        return allWordsIndices.values().stream().noneMatch((index) -> ((int)index == -1));
    }
}
