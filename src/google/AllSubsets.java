import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AllSubsets {
    public static class CustomComparator implements Comparator<List<Integer>>{

        @Override
        public int compare(List<Integer> arr1, List<Integer> arr2) {
            System.out.println("\n\nchecking the following lists:");
            arr1.forEach(System.out::print);
            System.out.println();
            arr2.forEach(System.out::print);

            System.out.println("\ncomparing references");
            if (arr1 == arr2) { // Quick check for same reference
                return 0;
            }

            System.out.println("comparing sizes");
            if (arr1 == null || arr2 == null || arr1.size() != arr2.size()) {
                return arr1.size() - arr2.size(); // Different lengths or null arrays
            }

            System.out.println("comparing elements");
            Set<Integer> set1 = new HashSet<>(arr1);
            Set<Integer> set2 = new HashSet<>(arr2);
            if(!set1.equals(set2)) return -1;

            System.out.println("all elements match");
            return 0; // All elements match
        }
    }

    static int[] allNums;
    static Set<List<Integer>> allSubsets = new TreeSet<>(new CustomComparator());

    public static List<List<Integer>> subsets(int[] nums) {
        allNums = nums;
        traverseArr(0, new ArrayList<>());

        return new ArrayList<>(allSubsets);
    }

    private static void traverseArr(int idx, List<Integer> subset) {
        if (idx == allNums.length - 1) {
            List<Integer> temp1 = new ArrayList<Integer>();
            temp1.addAll(subset);
            allSubsets.add(temp1);

            List<Integer> temp2 = new ArrayList<Integer>();
            temp2.addAll(subset);
            temp2.add(allNums[idx]);
            allSubsets.add(temp2);
            return;
        }

        List<Integer> temp1 = new ArrayList<Integer>();
        temp1.addAll(subset);
        traverseArr(idx + 1, temp1);
        List<Integer> temp2 = new ArrayList<Integer>();
        temp2.addAll(subset);
        temp2.add(allNums[idx]);
        traverseArr(idx + 1, temp2);
    }

    public static void main(String[] args) {
        subsets(new int[]{5, 5, 5, 5, 5});

        for(List<Integer> list: allSubsets) {
            list.forEach(System.out::print);
            System.out.println();
        }
    }
}