class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(c - stack.peek()) == 32) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}


/*
The time complexity of the provided code is O(n), where n is the length of the input string s.
This is because the code iterates through each character of the string exactly once in the for loop, performing constant-time operations inside the loop.
Additionally, the while loop at the end also iterates through the elements of the stack, but since each character is pushed and popped at most once, the overall time complexity remains O(n).

The space complexity is also O(n), where n is the length of the input string s.
This is because the code uses a stack data structure, which can potentially hold up to n/2 elements in the worst case scenario (for alternating characters), and the StringBuilder result can also hold up to n characters.
Therefore, the space complexity is linear with respect to the size of the input string.
*/
