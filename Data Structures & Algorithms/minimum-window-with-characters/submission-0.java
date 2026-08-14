class Solution {
    public String minWindow(String s, String t) {

    Map<Character, Integer> m1 = new HashMap<>();
    Map<Character, Integer> m2 = new HashMap<>();

   
    for(char ch : t.toCharArray()) {
        m1.put(ch, m1.getOrDefault(ch, 0) + 1);
    }

    int left = 0;
    int minlen = Integer.MAX_VALUE;
    int minst = 0;

    for(int right = 0; right < s.length(); right++) {

        char ch = s.charAt(right);
        m2.put(ch, m2.getOrDefault(ch, 0) + 1);

        
        while(checkmap(m1, m2)) {

            if(right - left + 1 < minlen) {
                minlen = right - left + 1;
                minst = left;
            }

            char remove = s.charAt(left);
            m2.put(remove, m2.get(remove) - 1);

            left++;
        }
    }

    if(minlen == Integer.MAX_VALUE)
        return "";

    return s.substring(minst, minst + minlen);
}

private boolean checkmap(Map<Character, Integer> m1,
                         Map<Character, Integer> m2) {

    for(char ch : m1.keySet()) {

        if(!m2.containsKey(ch) || m1.get(ch) > m2.get(ch)) {
            return false;
        }
    }

    return true;
}
}
