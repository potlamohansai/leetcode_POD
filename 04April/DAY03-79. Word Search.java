class Solution {
    int[] rows = {-1, 0, 0, 1};
    int[] cols = {0, -1, 1, 0};
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j])
            return false;
        
        visited[i][j] = true;

        for(int k=0; k<4; k++){
            int newRow = i + rows[k];
            int newCol = j + cols[k];
            if (dfs(board, word, newRow, newCol, index + 1)){
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}

/*
The time complexity of the provided code is O(N * M * 4^L), where N is the number of rows in the board, M is the number of columns in the board, and L is the length of the word.

Here's the breakdown:

The outer loop iterates over each cell in the board, which gives O(N * M).
Inside the loop, the DFS function is called for each cell, and in the worst case, the DFS function explores all possible directions, which are 4 directions (up, down, left, right) for each cell.
Therefore, the time complexity of DFS is O(4^L), where L is the length of the word.
  
The space complexity is O(N * M) due to the boolean array visited, which keeps track of visited cells in the board.
Additionally, the recursion stack can go as deep as the length of the word (L) during the DFS traversal.
Therefore, the overall space complexity is dominated by the boolean array and is linear with respect to the number of cells in the board.
*/
