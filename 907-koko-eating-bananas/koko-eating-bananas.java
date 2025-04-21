class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;

        for(int pile : piles){
            high = Math.max(high, pile);
        }

        while(low < high){
            int mid = low + (high - low) / 2;

            if(canFinish(mid, piles, h)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return low;
    }

    boolean canFinish(int speed, int piles[], int h){
        int hour = 0;

        for(int pile : piles){
            hour += Math.ceil((double)pile / speed);
        }

        return hour <= h;
    }
}