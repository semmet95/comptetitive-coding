import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        
        String s = "We promptly judged antique ivory buckles for the next prize";
        Set<Character> allChars = new HashSet<>();

        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) {
                allChars.add(s.charAt(i));
            }
        }

        System.out.println(allChars.size());
    }
}
