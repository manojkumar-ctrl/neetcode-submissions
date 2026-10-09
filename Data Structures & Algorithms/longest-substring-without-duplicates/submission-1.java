class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> st=new HashSet<>();
        // for(char i : s.toCharArray()){
        //     st.add(i);
        // }
        int max=0;
        int left=0;
        for(int i=0;i<s.length();i++){

            while(st.contains(s.charAt(i))){
                st.remove(s.charAt(left));
                left++;
            }
            st.add(s.charAt(i));

            int idx=i-left+1;
            max=Math.max(max,idx);
        }

        return max;
    }
}
