class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s: strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String s1 = new String(ch);
            if(hm.containsKey(s1)){
                hm.get(s1).add(s);
            }else{
                hm.put(s1, new ArrayList<>());
                hm.get(s1).add(s);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String i: hm.keySet()){
            ans.add(hm.get(i));
        }
        return ans;
    }
}