// https://www.hackerrank.com/contests/amazon/challenges/connected-sets

package amazon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConnectedSets {
    
    private static int[][] islands;
    private static boolean[][] islandTaken;
    private static int N;
    
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            
            N = Integer.parseInt(br.readLine());
            islands = new int[N][N];
            islandTaken = new boolean[N][N];
            int setCount = 0;
            
            for(int r = 0; r < N; r++) {
                
                String[] inps = br.readLine().split(" ");
                for(int c = 0; c < N; c++) islands[r][c] = Integer.parseInt(inps[c]);
            }
            
            for(int r = 0; r < N; r++) {
                
                for(int c = 0; c < N; c++) {
                    
                    Cell cell = new Cell(r, c);
                    
                    if(!islandTaken[r][c] &&(islands[r][c] == 1)) {
                        
                        islandTaken[r][c] = true;
                        connectSet(cell);
                        ++setCount;
                    }
                    
                }
            }
            
            System.out.println(setCount);
        }
    }
    
    private static void connectSet(Cell cell) {
        
        ArrayList<Cell> neighbors = getNeighbors(cell);
        ArrayList<Cell> connectedSet = new ArrayList<>(N * N);
        
        connectedSet.add(cell);
        
        for(int i = 0; i < connectedSet.size(); i++) {
            
            Cell connectedCell = connectedSet.get(i);
            
            getNeighbors(connectedCell).stream().filter((neighbor) -> (!islandTaken[neighbor.r][neighbor.c] && (islands[neighbor.r][neighbor.c] == 1))).map((neighbor) -> {
                islandTaken[neighbor.r][neighbor.c] = true;
                return neighbor;
            }).forEachOrdered((neighbor) -> {
                connectedSet.add(neighbor);
            });
        }
    }
    
    private static ArrayList<Cell> getNeighbors(Cell cell) {
        
        ArrayList<Cell> neighbors = new ArrayList<>();
        int r = cell.r, c = cell.c;
        
        for (int nr = Math.max(0, r - 1); nr <= Math.min(r + 1, islands.length - 1); ++nr) {
            
            for (int nc = Math.max(0, c - 1); nc <= Math.min(c + 1, islands[nr].length - 1); ++nc) {
                
                if (!(nr==r && nc==c))  { 
                    
                    Cell temp = new Cell(nr, nc);
                    neighbors.add(temp);
                }
            }
        }
        
        return neighbors;
    }
            
    private static class Cell {
        private int r, c;

        Cell(int row, int col) {
            
            r = row;
            c = col;
        }
    }
}