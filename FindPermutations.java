package backTracking;

import java.util.ArrayList;
import java.util.HashSet;

public class FindPermutations {
    public static ArrayList<String> findPermutation(String s) {
        HashSet<String> res = new HashSet<>();
        permutations(s, res, "");
        return new ArrayList<>(res); 
    }

    static void permutations(String s, HashSet<String> res, String ans) {
        if (s.length() == 0) {
            res.add(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String newStr = s.substring(0, i) + s.substring(i + 1);
            permutations(newStr, res, ans + ch);
        }
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("ABC"));
    }
}
