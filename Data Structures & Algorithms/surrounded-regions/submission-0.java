class Solution {
    public void solve(char[][] board) {
      int n=board.length;
        int m=board[0].length;
        int[][] vis=new int[n][m];
        int[] delrow={-1,0,1,0};
        int[] delcol={0,1,0,-1};

       //fir rwo
       for(int j=0;j<m;j++){
        if(vis[0][j]==0 && board[0][j]=='O'){
            dfs(0,j,vis,board,delrow,delcol);
        }

       //lastrow
       if(vis[n-1][j]==0 && board[n-1][j]=='O'){
        dfs(n-1,j,vis,board,delrow,delcol);
       }

       }

       for(int i=0;i<n;i++){

        //fir col
        if(vis[i][0]==0 && board[i][0]=='O'){
            dfs(i,0,vis,board,delrow,delcol);  //0 cuz last will overlap with last row alredt chedcded
        }

        //last col
            if(vis[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,vis,board,delrow,delcol);
            }
       }
       
    //convert rem all O to XX bound regins
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++ ){
            if(vis[i][j]==0 && board[i][j]=='O'){
                board[i][j]='X';
            }
        }
    }
    }

    public void dfs(int row, int col, int vis[][], char[][] mat, int[] delrow, int[] delcol){
        int n=mat.length;
        int m=mat[0].length;

            vis[row][col]=1;
        
        for(int i=0;i<4;i++){
            int nr=row+delrow[i];
            int nc=col+delcol[i];


            if(nr>=0 && nr<n && nc>=0 && nc<m && mat[nr][nc]=='O' && vis[nr][nc]==0){
                    dfs(nr,nc,vis,mat,delrow,delcol);
            }
        }
    }

}

