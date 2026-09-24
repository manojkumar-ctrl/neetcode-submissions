class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> temp=new ArrayList<>();
        int[] f=intervals[0];
        temp.add(f);

        for(int[] curr : intervals){
            if(curr[0]<=f[1]){
                f[1]=Math.max(curr[1],f[1]);
            }
            else{
                temp.add(curr);
                f=curr;
            }
        }

        return temp.toArray(new int[temp.size()][]);
    }
}
