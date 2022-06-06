package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.math.BigInteger;

class SolutionSHA256 {

    public static void main(String[] args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var s = br.readLine();
        var digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));

        var hex = String.format("%064x", new BigInteger(1, hash));
        
        System.out.println(hex);
    }
}