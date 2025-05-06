class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // using bellom ford alogorithm

        int price[] = new int [n];
        // mark all the value of price is infinitee
        Arrays.fill(price, Integer.MAX_VALUE);

        // we iterate with k+1 stop

        price[src] = 0;

        for(int i=0; i<= k; i++){
            // declear temp arr to updates curr prices

            int temp[] = Arrays.copyOf(price, n);

            // go in each filght:
            for(int[] flight : flights){
                int s = flight[0];
                int d = flight[1];
                int p = flight[2];

                // check price if stilll infinite then not procedd 

                if(price[s] == Integer.MAX_VALUE){
                    continue;
                }


                // comapre minmum price
                if(price[s] + p < temp[d]){
                    temp[d] = price[s] + p;
                }
            } 

            price = temp;
        }

        return price[dst] == Integer.MAX_VALUE? -1 : price[dst];
    }
}