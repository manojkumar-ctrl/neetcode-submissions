class Pair {
    int f, s;

    public Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int maxarea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area = bfs(grid, vis, i, j);
                    maxarea = Math.max(maxarea, area);
                }
            }
        }
        return maxarea;
    }

    public int bfs(int[][] grid, boolean[][] vis, int row, int col) {

        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));
        vis[row][col] = true;
        int area = 0;

        while (!q.isEmpty()) {
            Pair it = q.poll();
            int r = it.f;
            int c = it.s;
            area++;
            
            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    !vis[nr][nc] &&
                    grid[nr][nc] == 1) {

                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }

        return area;
    }
}