class Solution {
    public int differenceOfSums(int n, int m) {
        int num1_sum = 0;
        int num2_sum= 0;
        for(int i=1; i<=n; i++){
            if((i % m) == 0 && i >= m){
                num2_sum += i;
            }else{
                num1_sum += i;
            }
        }

        return num1_sum - num2_sum;
    }
}