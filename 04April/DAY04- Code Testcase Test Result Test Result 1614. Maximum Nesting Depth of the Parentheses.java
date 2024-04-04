class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int ans = 0;
        int count = 0;

        for(int i =0; i<n; i++){
            char c = s.charAt(i);
            if( c == '('){
                count += 1;
            }else if(c == ')'){
                ans = Math.max(ans, count);
                count -= 1;
            }
        }
        return ans;
    }
}


/*
The time complexity of the provided code is O(n), where n is the length of the input string s.
This is because the code iterates through each character of the string exactly once in the for loop, performing constant-time operations inside the loop.

The space complexity is also O(1).
The space used by the variables n, ans, and count is constant, regardless of the size of the input string.
Therefore, the space complexity remains constant with respect to the input size.
  */
