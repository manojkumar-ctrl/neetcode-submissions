class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer>mp=new HashMap<>();

        for(int i=0;i<numbers.length;i++){
            int left=target-numbers[i];
            if(mp.containsKey(left)){
                return new int[]{mp.get(left)+1,i+1};
            }

            mp.put(numbers[i],i);
        }

        return new int[]{};
    }
}
