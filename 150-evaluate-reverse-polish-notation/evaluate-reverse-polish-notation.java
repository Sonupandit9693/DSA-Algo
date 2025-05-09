class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens){
            if(isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();

                int result = calculateResult(token, a, b);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    boolean isOperator(String token){
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    int calculateResult(String token, int a, int b){
        switch(token){
            case "+" : return a + b;
            case "-" : return a - b;
            case "*" : return a * b;
            case "/" : return a / b;
            default : throw new IllegalArgumentException("Invalid operrator");
        }
    }
}