class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int minspeed=1;
        int maxspeed=0;
        for(int i:piles) maxspeed=Math.max(maxspeed,i);


        while(minspeed<maxspeed){
            int mid=minspeed+(maxspeed-minspeed)/2;

            if(caneat(piles,h,mid)){
                maxspeed=mid;
            }
            else minspeed=mid+1;
        }

        return minspeed;
    }

    public boolean caneat(int[] piles, int h, int speed){
        int hrs=0;
        for(int i:piles){
            hrs+=(int)Math.ceil((double)i/speed);
        }

       return (hrs<=h);
    }
}
