class Pair{
    int row,col,time;
    public Pair(int row,int col, int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}


class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int cntFresh=0;
        int cnt=0;
        int[][] vis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else{
                    vis[i][j]=0;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }
        int tm=0;
            int[] drow={-1,0,+1,0};
            int[] dcol={0,+1,0,-1};

        while(!q.isEmpty()){
            Pair it=q.poll();
            int r=it.row;
            int c=it.col;
            int t=it.time;

            tm=Math.max(tm,t);

            for(int i=0;i<4;i++){
                int nrow=r+drow[i];
                int ncol=c+dcol[i];

                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]!=2){
                    q.offer(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=cntFresh){
            return -1;
        }

        return tm;

    }
}