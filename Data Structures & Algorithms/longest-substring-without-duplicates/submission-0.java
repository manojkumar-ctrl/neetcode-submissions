class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> st=new HashSet<>();
        int left=0;
      int res=0;
        for(int i=0;i<s.length();i++){
            while(st.contains(s.charAt(i))){
                    st.remove(s.charAt(left));
                    left++;
            }

            st.add(s.charAt(i));
            int idx=i-left+1;
            res=Math.max(res,idx);
        }

        return res;
    }
}
