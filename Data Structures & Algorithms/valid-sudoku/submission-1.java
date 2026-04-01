//3 * O(n^2) ... O(n^2)
class Solution {
    public boolean isValidSudoku(char[][] board) {
        //first check all sub boxes:
        for(int i = 0; i < board.length; i += 3){
            for(int j = 0; j < board.length; j += 3) {
                if(!validSub(i, j, board)) {
                    return false;
                }
            }
        }

        //check all rows and columns
        for(int i = 0; i < board.length; i++) {
            if(!validRow(i, board) || !validCol(i, board)) {
                return false;
            }
        }
        return true;
    }

    //start represents the sub
    private boolean validSub(int startX, int startY, char[][] board) {
        boolean[] occurance = new boolean[10];
        for(int i = startX; i < startX + 3; i++) {
            for(int j = startY; j < startY + 3; j++) {
                if(board[i][j] != '.') {
                    if(occurance[board[i][j] - '0']) {
                        return false;
                    }
                    occurance[board[i][j] - '0'] = true;
                }
            }
        }

        return true;
    }

    private boolean validRow(int index, char[][] board) {
        boolean[] occurance = new boolean[10];
        for(int i = 0; i < board.length; i++) {
            if(board[index][i] != '.') {    
                if(occurance[board[index][i] - '0']) {
                    return false;
                }
                occurance[board[index][i] - '0'] = true;
            }
        }

        return true;
    }

    private boolean validCol(int index, char[][] board) {
        boolean[] occurance = new boolean[10];
        for(int i = 0; i < board.length; i++) {
            if(board[i][index] != '.') {    
                if(occurance[board[i][index] - '0']) {
                    return false;
                }
                occurance[board[i][index] - '0'] = true;
            }
        }

        return true;
    }
}
