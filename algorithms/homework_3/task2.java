package homework_graph;

import java.util.*;


public class task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int s = in.nextInt();

        List<int[]>[] g = new List[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = in.nextInt(), v = in.nextInt(), w = in.nextInt();
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }

        final long INF = Long.MAX_VALUE;
        long[] dist = new long[n];
        Arrays.fill(dist, INF);
        dist[s] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, s});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            if (d > dist[u]) continue;
            for (int[] e : g[u]) {
                int v = e[0];
                long nd = d + e[1];
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.add(new long[]{nd, v});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int unreachable = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) sb.append(' ');
            if (dist[i] == INF) {
                sb.append(-1);
                unreachable++;
            } else {
                sb.append(dist[i]);
            }
        }
        sb.append(" unreachable=").append(unreachable);
        System.out.println(sb);
    }
}