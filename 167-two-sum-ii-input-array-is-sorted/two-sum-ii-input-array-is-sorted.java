class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right){
            // check if sum > target then dcress right and if greater then incres left
            if(numbers[left] + numbers[right] > target){
                right --;
            }else if(numbers[left] + numbers[right] < target){
                left ++;
            }else{
                return new int []{left+1, right+1};
            }
        }

        return null;
    }
}