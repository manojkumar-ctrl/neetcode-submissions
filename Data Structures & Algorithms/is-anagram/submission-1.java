class Solution {
    public boolean isAnagram(String s, String t) {
      Map<Character,Integer> mp=new HashMap<>();
      Map<Character,Integer> m2=new HashMap<>();

      for(char ch : s.toCharArray()){
        mp.put(ch,mp.getOrDefault(ch,0)+1);
      }

      for(char ch : t.toCharArray()){
        m2.put(ch,m2.getOrDefault(ch,0)+1);
      }

      return mp.equals(m2);



    }
}
