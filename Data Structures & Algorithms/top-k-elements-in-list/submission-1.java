class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(hm.get(b), hm.get(a)));
        for(int i: hm.keySet()){
            pq.add(i);
        }
        int ans[] = new int[k];
        int j=0;
        while(k>0){
            ans[j++]=pq.poll();
            k--;
        }
        return ans;
    }
}
