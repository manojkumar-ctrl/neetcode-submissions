class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String,List<String>> mp=new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            char[] unsortedstr=str.toCharArray();
            Arrays.sort(unsortedstr);
            String key=new String(unsortedstr);

            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
            }
          
            mp.get(key).add(str);
            
        }

        for(List<String> val : mp.values()){
            res.add(val);
        }

        return res;
    }
}
