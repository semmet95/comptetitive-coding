package hiringchallenges;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

public class FindingTheBox {
    public static void main(String args[]) throws Exception {
        
        Scan br = new Scan();
        
        int N = Integer.parseInt(br.scanString());
        //br.scanString();
        String[] inps = br.scanString().split(" ");
        //System.out.println(inps[0]);
        
        long[] mCumulative = new long[N];
        mCumulative[0] = Long.parseLong(inps[0]);
        
        for(int i = 1; i < N; i++) mCumulative[i] = Long.parseLong(inps[i]) + mCumulative[i-1];
        
        int Q = br.scanInt();
        long[] queries = new long[Q];
        HashMap<Long, Integer> querAns = new HashMap<>();
        
        for(int i = 0; i < Q; i++) queries[i] = br.scanLong();
        
        long[] queryCopy = Arrays.copyOf(queries, Q);
        Arrays.sort(queries);
        
        //int qIdx, mArrIdx;
        int mArrIdx = 0;
        for(int qIdx = 0; qIdx < Q; qIdx++) {
            
            while(mCumulative[mArrIdx] < queries[qIdx]) ++mArrIdx;
            
            querAns.put(queries[qIdx], mArrIdx+1);
        }
        
        for(long ele: queryCopy) System.out.println(querAns.get(ele));
    }
    
    private static class Scan
    {
        private final byte[] buf=new byte[1024];
        private int index;
        private final InputStream in;
        private int total;
        public Scan()
        {
            in=System.in;
        }
        public int scan()throws IOException
        {
            if(total<0)
            throw new InputMismatchException();
            if(index >= total)
            {
                index=0;
                total=in.read(buf);
                if(total<=0)
                return -1;
            }
            return buf[index++];
        }
        public int scanInt()throws IOException
        {
            int integer=0;
            int n=scan();
            while(isWhiteSpace(n))
            n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n))
            {
                if(n>='0'&&n<='9')
                {
                    integer*=10;
                    integer+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return neg*integer;
        }
        public long scanLong()throws IOException
        {
            long doub=0;
            int n=scan();
            while(isWhiteSpace(n))
            n=scan();
            int neg=1;
            if(n=='-')
            {
                neg=-1;
                n=scan();
            }
            while(!isWhiteSpace(n)&&n!='.')
            {
                if(n>='0'&&n<='9')
                {
                    doub*=10;
                    doub+=n-'0';
                    n=scan();
                }
                else throw new InputMismatchException();
            }
            return doub*neg;
        }
        public String scanString()throws IOException
        {
            StringBuilder sb=new StringBuilder();
            int n=scan();
            while(isWhiteSpace(n))
            n=scan();
            while(n != '\n')
            {
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
}