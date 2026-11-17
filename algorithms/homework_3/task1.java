package homework_graph;

import java.util.*;

public class task1 {
    static int h, w;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        h = in.nextInt();
        w = in.nextInt();
        map = new char[h][];
        for (int i = 0; i < h; i++) map[i] = in.next().toCharArray();
        int sr = in.nextInt(), sc = in.nextInt(), tr = in.nextInt(), tc = in.nextInt();

        boolean[][] visD = new boolean[h][w];
        int cntD = dfs(sr, sc, visD);

        boolean reach = tr >= 0 && tr < h && tc >= 0 && tc < w && visD[tr][tc];

        boolean[][] visB = new boolean[h][w];
        int cntB = bfs(sr, sc, visB);

        if (reach) System.out.println("YES " + cntD + " " + cntB);
        else System.out.println("NO 0 0");
    }

    static int dfs(int r0, int c0, boolean[][] vis) {
        if (r0 < 0 || r0 >= h || c0 < 0 || c0 >= w || map[r0][c0] == '#') return 0;
        int cnt = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{r0, c0});
        while (!stack.isEmpty()) {
            int[] p = stack.pop();
            int r = p[0], c = p[1];
            if (r < 0 || r >= h || c < 0 || c >= w) continue;
            if (map[r][c] == '#' || vis[r][c]) continue;
            vis[r][c] = true;
            cnt++;
            for (int i = 0; i < 4; i++) stack.push(new int[]{r + dr[i], c + dc[i]});
        }
        return cnt;
    }

    static int bfs(int r0, int c0, boolean[][] vis) {
        if (r0 < 0 || r0 >= h || c0 < 0 || c0 >= w || map[r0][c0] == '#') return 0;
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        vis[r0][c0] = true;
        q.add(new int[]{r0, c0});
        cnt++;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = p[0] + dr[i], nc = p[1] + dc[i];
                if (nr < 0 || nr >= h || nc < 0 || nc >= w) continue;
                if (map[nr][nc] == '#' || vis[nr][nc]) continue;
                vis[nr][nc] = true;
                cnt++;
                q.add(new int[]{nr, nc});
            }
        }
        return cnt;
    }
}
