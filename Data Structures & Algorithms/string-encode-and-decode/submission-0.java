class Solution {

    public String encode(List<String> strs) {
        StringBuilder ans=new StringBuilder();
        for(String s : strs){
            ans.append(s.length()).append("/:").append(s);
        }
        
        return ans.toString();
    }

    public List<String> decode(String str) {
             ArrayList<String> res = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
        int j = str.indexOf("/:", i);
        int len = Integer.parseInt(str.substring(i, j));
        i = j + 2;
        res.add(str.substring(i, i + len));
        i += len;
    }

    return res;
    }
}
