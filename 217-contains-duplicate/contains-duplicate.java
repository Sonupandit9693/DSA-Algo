class Solution {
    public boolean containsDuplicate(int[] nums) {
        // create hashset to check any other duplicast elemnt
        HashSet<Integer> duplicateNum = new HashSet<>();
        for(int num : nums){
            if(!duplicateNum.contains(num)){
                duplicateNum.add(num);
            }else{
                return true;
            }
        }

        return false;
    }
}