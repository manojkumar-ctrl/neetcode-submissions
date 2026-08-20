class Pair {
    int f, s;

    public Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {

    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        // Put ALL treasure cells into queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            Pair it = q.poll();

            int r = it.f;
            int c = it.s;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    grid[nr][nc] == Integer.MAX_VALUE) {

                    grid[nr][nc] = grid[r][c] + 1;

                    q.add(new Pair(nr, nc));
                }
            }
        }
    }
}