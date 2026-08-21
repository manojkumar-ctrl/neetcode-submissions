class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] p: prerequisites){
            adj.get(p[1]).add(p[0]);
        }

        int[] indeg=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indeg[it]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indeg[i]==0) q.add(i);
        }

        ArrayList<Integer> res=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.poll();
            res.add(node);
            for(int it : adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }
        }

        int[] ans=new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }

        if(numCourses==res.size()) return ans;

        return new int[]{};

    }
}
