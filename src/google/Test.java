import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        
        String s = "promptly";
        List<String> unsorted = Arrays.asList(s.split(""));
        
        Collections.sort(unsorted);

        unsorted.forEach(System.out::print);

        Queue<Coordinate> nextMoves = new LinkedList<>();

        while(nextMoves.peek() != null) {
            nextMoves.poll();
        }
        //nextMoves.addAll(c)

        Set<Coordinate> visitedMoves = new HashSet<>();

        //nextMoves.stream().filter(move -> !visitedMoves.contains(move)).collect(collector)
        //visitedMoves.contains(o)
        
    }

    static List<Coordinate> getNextCoordinate(Coordinate current, int N) {
        int i = current.i;
        int j = current.j;
        
        Coordinate[] moves = {
            new Coordinate(i+1, j+2),
            new Coordinate(i+1, j-2),
            new Coordinate(i-1, j+2),
            new Coordinate(i-1, j-2),
            new Coordinate(i+2, j+1),
            new Coordinate(i+2, j-1),
            new Coordinate(i-2, j+1),
            new Coordinate(i-2, j-1)
        };

        List<Coordinate> temoList = new ArrayList<>();
        
        
        Arrays.stream(moves).filter(coordinate -> (coordinate.i >= 0 && coordinate.i < N && coordinate.j >= 0 && coordinate.j < N))
        .forEach(temoList::add);
            //.collect(Collectors.toList());

            return null;
    }

    public static int flippingMatrix(List<Integer> arr) {
        int sum = 0;
        
        List<Integer> diffs =  IntStream.range(0, arr.size()-1)
            .map(i -> arr.get(i+1) - arr.get(i))
            .boxed()
            .collect(Collectors.toList());
    
        return sum;
    }

    static class Coordinate {
        public int i;
        public int j;
        
        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
