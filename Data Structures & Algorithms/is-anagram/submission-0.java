class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
            char[] s1=s.toCharArray();
            char[] t2=t.toCharArray();

            Arrays.sort(s1);
            Arrays.sort(t2);

            return Arrays.equals(s1, t2);

            

    }
}
