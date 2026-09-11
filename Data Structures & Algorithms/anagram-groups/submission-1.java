class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
    Map<String, List<String>> mp=new HashMap<>();
        for(int i=0;i<strs.length;i++){

            String str=strs[i];
            char[] unsort=str.toCharArray();
            Arrays.sort(unsort);
            String key=new String(unsort);

            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
            }

            mp.get(key).add(str);

        }

        for(List<String> temp : mp.values()){
            res.add(temp);
        }

        return res;
    }
}
