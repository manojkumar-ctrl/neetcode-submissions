class Solution {
    public boolean isValidSudoku(char[][] board) {
          for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!='.'){
                    if(!isvalid(board,i,j,board[i][j])){
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isvalid(char[][] board, int r, int c, char val){
        for(int i=0;i<9;i++){

            //row cheack
            if(board[r][i]==val && i!=c){
                return false;
            }

            //col check
            if(board[i][c]==val && i!=r){
                return false;
            }

            int d1=3*(r/3)+(i/3);
            int d2=3*(c/3)+(i%3);

             if(board[d1][d2]==val && (d1!=r || d2!=c))  return false;
        }

        return true;
    }
}
