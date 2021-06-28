package hackerrank;

import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    PerformOperation isOdd() {
        return a -> a%2 == 1;
    }

    PerformOperation isPrime() {
        return a ->  {
            if(a == 2 || a == 3) return true;

            for(var i = 2; i < Math.sqrt(a); i++) if(a%i == 0) return false;

            return true;
        };
    }

    PerformOperation isPalindrome() {
        return a ->  new StringBuffer(String.valueOf(a)).reverse().toString().equals(String.valueOf(a));
    }
}

class Solution {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  boolean ret = false;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ret = ob.checker(op, num);
    ans = (ret) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ret = ob.checker(op, num);
    ans = (ret) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ret = ob.checker(op, num);
    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
   //System.out.println(new StringBuilder("989").reverse().toString().equals("989"));
  }
 }
}
