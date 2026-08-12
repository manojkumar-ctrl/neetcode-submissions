class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int left=0, maxlen=0;
        int maxfreq=0;
        int res=0;
        for(int i=0;i<s.length();i++){
            char let=s.charAt(i);
            mp.put(let,mp.getOrDefault(let,0)+1);
            maxfreq=Math.max(maxfreq,mp.get(let));
            maxlen++;
            int changes=maxlen-maxfreq;

            while(changes>k){
                char toberem=s.charAt(left);
                mp.put(toberem,mp.get(toberem)-1);
                left++;
                maxlen--;
                changes=maxlen-maxfreq;
            }
            res=Math.max(maxlen,res);


        }

        return res;
    }
}
