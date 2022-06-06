package hackerrank;

import java.io.*;
import java.security.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5 {
    
    public static void main(String[] args) throws Exception {

        var br = new BufferedReader(new InputStreamReader(System.in));
        var s = br.readLine();
        var digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(s.getBytes(StandardCharsets.UTF_8));

        var hex = String.format("%x", new BigInteger(1, hash));
        
        System.out.println(hex);
    }

}
