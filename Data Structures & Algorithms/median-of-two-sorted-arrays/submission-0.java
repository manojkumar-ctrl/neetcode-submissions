class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> comb=new ArrayList<>();

        for(int i=0;i<nums1.length;i++){
            comb.add(nums1[i]);
        }
         for(int i=0;i<nums2.length;i++){
            comb.add(nums2[i]);
        }

        Collections.sort(comb);

         int n = comb.size();
        if(n % 2 == 0){
            return (comb.get(n/2-1) + comb.get(n/2)) / 2.0;
        }

        return comb.get(n/2);

    }
}
