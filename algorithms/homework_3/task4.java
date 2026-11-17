package homework_graph;

import java.util.*;

public class task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        int[] indeg = new int[n];

        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt();
            g[u].add(v);
            indeg[v]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);

        int[] order = new int[n];
        int cnt = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            order[cnt++] = u;
            for (int v : g[u]) {
                if (--indeg[v] == 0) q.add(v);
            }
        }

        if (cnt < n) {
            System.out.println("CYCLE");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append(order[i]);
            }
            System.out.println(sb);
        }
    }
}