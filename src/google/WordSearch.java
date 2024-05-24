import java.util.HashSet;
import java.util.Set;

public class WordSearch {
    boolean wordFound = false;
    String inp;
    char[][] matrix;

    public boolean exist(char[][] board, String word) {
        inp = word;
        matrix = board;

        for(byte row = 0; row < matrix.length; row++) {
            for(byte col = 0; col < matrix[0].length; col++) {
                checkAdjacent(row, col, (byte)0, new HashSet<>());

                if(wordFound) return true;
            }
        }

        return false;
    }

    private void checkAdjacent(byte row, byte col, byte idx, Set<String> visitedCells) {
        if(wordFound) return;

        if(inp.charAt(idx) != matrix[row][col]) return;

        //System.out.println("in cell: " + row + ", " + col);

        if(idx == inp.length() - 1) {
            wordFound = true;
            return;
        }

        visitedCells.add(new StringBuilder().append(row).append(",").append(col).toString());

        // check the cell up
        if(row > 0 && !visitedCells.contains(new StringBuilder().append(row - 1).append(",").append(col).toString())) {
            checkAdjacent((byte)(row - 1), col, (byte)(idx + 1), visitedCells);
        }

        // check the cell down
        //System.out.println("here are all the cells visited::");
        //for(String cell : visitedCells) {
        //    System.out.println(cell);
        //}
        //System.out.println("checking if i can go down from cell: " + row + ", " + col);
        //System.out.println("checking if down cell: " + new StringBuilder().append(row + 1).append(",").append(col).toString() + " is present in visited cells: " + visitedCells.contains(new StringBuilder(row + 1).append(",").append(col).toString()));
        if(row < matrix.length - 1 && !visitedCells.contains(new StringBuilder().append(row + 1).append(",").append(col).toString())) {
            checkAdjacent((byte)(row + 1), col, (byte)(idx + 1), visitedCells);
        }

        // check the cell left
        if(col > 0 && !visitedCells.contains(new StringBuilder().append(row).append(",").append(col - 1).toString())) {
            checkAdjacent(row, (byte)(col - 1), (byte)(idx + 1), visitedCells);
        }

        // check the cell right
        if(col < matrix[0].length - 1 && !visitedCells.contains(new StringBuilder().append(row).append(",").append(col + 1).toString())) {
            checkAdjacent(row, (byte)(col + 1), (byte)(idx + 1), visitedCells);
        }

        visitedCells.remove(new StringBuilder().append(row).append(",").append(col).toString());
        
    }
}
