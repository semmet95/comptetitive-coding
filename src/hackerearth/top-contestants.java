import java.io.*;
import java.util.*;


class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
          String[] first = br.readLine().split(" ");
         int N = Integer.parseInt(first[0]);
         int K = Integer.parseInt(first[1]);
         String[] arr_Score = br.readLine().split(" ");
         int[] Score = new int[N];
         for(int i_Score=0; i_Score<arr_Score.length; i_Score++)
         {
         	Score[i_Score] = Integer.parseInt(arr_Score[i_Score]);
         }

         int[] out_ = Find_K(K, Score, N);
         System.out.print(out_[0]);
         for(int i_out_=1; i_out_<out_.length; i_out_++)
         {
         	System.out.print(" " + out_[i_out_]);
         }

         wr.close();
         br.close();
    }
    static int[] Find_K(int K, int[] Score, int N){
        // Write your code here
        HashMap<Integer, Integer> elePosMap = new HashMap<>();

        PriorityQueue<Integer> topK = new PriorityQueue<>(Collections.reverseOrder());

        int index = 1;
        for (int ele: Score) {
            topK.add(ele);
            elePosMap.put(ele, index++);
        }

        int[] topKScores = new int[K];

        for(int i = 0; i < K; i++) {
            topKScores[i] = elePosMap.get(topK.poll());
        }

        return topKScores;
    }
}