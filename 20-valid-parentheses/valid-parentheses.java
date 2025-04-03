class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> tomapchar = new HashMap<>();

        tomapchar.put(')', '(');
        tomapchar.put('}', '{');
        tomapchar.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(! tomapchar.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char topElement = stack.pop();

                if(topElement != tomapchar.get(c)){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}