class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
         Deque<Integer> dq=new ArrayDeque<>();   //idx store in deq
        ArrayList<Integer> res=new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peekFirst()<=i-k){   //outside win  l--; 
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){    //decreas order
                dq.pollLast();
            }

            dq.offerLast(i);   //add r++;

            if(i>=k-1){     //add to res 
                res.add(nums[dq.peekFirst()]);   
            }
        }

        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }

        return ans;
    }
}
