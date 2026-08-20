class Pair{
    int r, c;
    public Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        boolean[][] vis=new boolean[n][m];
        int res=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    res++;
                    bfs(grid,vis,i,j);
                }
            }
        }

        return res;
    }

    public void bfs(char[][] grid, boolean[][] vis, int row, int col){
        int n=grid.length;
        int m=grid[0].length;
        int[] dr={-1,0,+1,0};
        int[] dc={0,+1,0,-1};
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(row,col));
        vis[row][col]=true;
    while(!q.isEmpty()){
        Pair it=q.poll();
        int r=it.r;
        int c=it.c;   
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];

            if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==false && grid[nr][nc]=='1'){
                q.add(new Pair(nr,nc));
                vis[nr][nc]=true;
            }
        }
    }

        
    }
}
