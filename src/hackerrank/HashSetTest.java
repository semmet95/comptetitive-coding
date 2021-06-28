package hackerrank;

import java.util.*;
public class HashSetTest {

    public static void main(String[] args) throws Exception {

        HashSet<Integer> setTest = new HashSet<>();
        setTest.add(2);
        setTest.add(3);
        
        Iterator<Integer> iterator = setTest.iterator();

        while(iterator.hasNext()) {
            Integer ele = iterator.next();
            setTest.add(4);
            System.out.println(ele);
        }

        
    }
    
}
