class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;

        while(left < right){
            // if left contains not nuber ot digit:
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left ++;
            }
            // check for right not contains number or digit
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right --;
            }

            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
                return false;
            }

            left ++;
            right --;
        }

        return true;
    }
}