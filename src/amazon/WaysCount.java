//https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/hp-and-counting-number-of-ways-1d73a6a4/

package amazon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;

class WaysCount {
    
    public static void main(String args[]) throws Exception {
        
        Print print = new Print();
        Scan br = new Scan();
        int T = br.scanInt();
        
        long[][] allSols = new long[101][10001];
        for(int r = 1; r <= 100; r++) {
            allSols[r][10000] = 1;
            allSols[r][10000-1] = 1;
        }
        
        // matrix with all the answers
        for(int K = 1; K <= 100; K++) {
            for(int stepsFromX = 2; stepsFromX <= 10000; stepsFromX++) {
                
                if (stepsFromX <= K){
                    allSols[K][10000 - stepsFromX] = 2 * allSols[K][10000 - (stepsFromX -1)];
                }
                else allSols[K][10000 - stepsFromX] = 2 * allSols[K][10000 - (stepsFromX - 1)] - allSols[K][10000 - (stepsFromX - (K+1))];
                
                allSols[K][10000 - stepsFromX] %= 1000000007;
                if(allSols[K][10000 - stepsFromX] < 0) allSols[K][10000 - stepsFromX] += 1000000007;
            }
        }
        
        while(T-- > 0) {
            
            String[] inps = br.scanString().split(" ");
            int X = Integer.parseInt(inps[0]);
            int K = Integer.parseInt(inps[1]);
            
            print.println(allSols[K][10000 - X]);
        }
        print.close();
    }
    
    // got this from
    // https://www.hackerearth.com/practice/notes/inputoutput-in-javascanner-bufferedreader-self-made-fast-io/
    private static class Scan {
        
        private final byte[] buf=new byte[1024];
        private int index;
        private final InputStream in;
        private int total;
        
        public Scan() { in = System.in; }
        
        public int scan()throws IOException {
            if(total<0) throw new InputMismatchException();
            
            if(index >= total) {
                
                index=0;
                total=in.read(buf);
                
                if(total<=0) return -1;
            }
            return buf[index++];
        }
        
        public int scanInt()throws IOException {
            
            int integer=0;
            int n=scan();
            
            while(isWhiteSpace(n)) n=scan();
            
            int neg=1;
            if(n=='-') {
                neg=-1;
                n=scan();
            }
            
            while(!isWhiteSpace(n)) {
                
                if(n>='0'&&n<='9') {
                    
                    integer*=10;
                    integer+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }
        
        public String scanString()throws IOException {
            
            StringBuilder sb=new StringBuilder();
            int n=scan();
            while(isWhiteSpace(n)) n=scan();
            
            while(n != '\n' && n != -1) {
                sb.append((char)n);
                n=scan();
            }
            return sb.toString();
        }
        private boolean isWhiteSpace(int n)
        {
            return n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1;
        }
    }
    
    private static class Print {
        
        private final BufferedWriter bw;
        public Print() {
            this.bw=new BufferedWriter(new OutputStreamWriter(System.out));
        }
        
        public void print(Object object)throws IOException {
            bw.append(""+object);
        }
        
        public void println(Object object)throws IOException {
            print(object);
            bw.append("\n");
            bw.flush();
        }
        
        public void close()throws IOException {
            bw.close();
        }
    }
}
