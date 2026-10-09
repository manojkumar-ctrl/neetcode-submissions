class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->mp.get(b)-mp.get(a));

        for(int i : mp.keySet()){
            pq.add(i);
        }
        
        int[] res=new int[k];
        int i=0;
        while(k!=0){
            res[i++]=pq.poll();
            k--;
        }

        return res;
    }
}
