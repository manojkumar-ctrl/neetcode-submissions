class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edg : edges){
            adj.get(edg[0]).add(edg[1]);
            adj.get(edg[1]).add(edg[0]);

        }

        int res=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(adj,vis,i);
                res++;
            }
        }
    return res;

    }

    public void bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        // vis[node]=true;
        while(!q.isEmpty()){
            int n=q.poll();
            vis[n]=true;

            for(int neigh : adj.get(n)){
                if(!vis[neigh]){
                q.add(neigh);
                vis[neigh]=true;
                }
            }
        }
    }
}
