public class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        HashMap<Character, Integer> s1Map = new HashMap<>();
        HashMap<Character, Integer> s2Map = new HashMap<>();

        // Initial window
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            s1Map.put(c1, s1Map.getOrDefault(c1, 0) + 1);
            s2Map.put(c2, s2Map.getOrDefault(c2, 0) + 1);
        }

        if (s1Map.equals(s2Map)) {
            return true;
        }

        int left = 0;

        // Sliding window
        for (int right = s1.length(); right < s2.length(); right++) {

            // Add right character
            char add = s2.charAt(right);
            s2Map.put(add, s2Map.getOrDefault(add, 0) + 1);

            // Remove left character
            char remove = s2.charAt(left);
            s2Map.put(remove, s2Map.get(remove) - 1);

            if (s2Map.get(remove) == 0) {
                s2Map.remove(remove);
            }

            left++;

            if (s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }
}
