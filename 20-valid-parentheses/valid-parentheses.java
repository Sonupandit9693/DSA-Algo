class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> tomapChar = new HashMap<>();

        tomapChar.put(')', '(');
        tomapChar.put(']', '[');
        tomapChar.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            if(! tomapChar.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char topElement = stack.pop();
                // stack.remove();

                if(topElement != tomapChar.get(c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}