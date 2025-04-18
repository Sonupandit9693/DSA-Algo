class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort the arry
        Arrays.sort(nums);

        // inotalize our result arraylist 
        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<nums.length -2; i++){
            // check duplicate
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            // incase get positive value i brek loop my ans not longer exits
            if(nums[i] > 0){
                break;
            } 

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    left ++;
                    right --;

                    // also check duplicate
                    while(left < right && nums[left] == nums[left -1]) left ++;
                    while(left < right && nums[right] == nums[right + 1]) right --;
                }else if(sum < 0){
                    left ++;
                }else{
                    right --;
                }
            }
        }

        return result;
    }
}