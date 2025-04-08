class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 1;

        for(int pile : piles){
            high = Math.max(high, pile);
        }

        // System.out.println("\nHeight of pliels: " + high);
       
        while(low < high){
            int mid = low + (high - low) / 2; // our Speed to the bannas
            System.out.println("low value: " +  low);
            System.out.println("high value: " +  high);
            if(canFinish(mid, piles, h)){

                // search minimun speed so go left part
                high = mid;
            }else{
                // other wise search on rigth that speed can finish then banna
                low = mid + 1;
            }

            

        }

        return low;
    }

    private boolean canFinish(int speed, int piles[], int h){
        int hour = 0;

        for(int pile : piles){
            hour += Math.ceil((double) pile / speed);
        }

        return hour <= h;
    }
}