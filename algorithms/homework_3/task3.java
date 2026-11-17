package homework_graph;

import java.util.*;

public class task3 {
    static int[] parent, rank;

    static int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    static boolean union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra == rb) return false;
        if (rank[ra] < rank[rb]) {
            int t = ra; ra = rb; rb = t;
        }
        parent[rb] = ra;
        if (rank[ra] == rank[rb]) rank[ra]++;
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = in.nextInt();
            edges[i][1] = in.nextInt();
            edges[i][2] = in.nextInt();
        }

        Arrays.sort(edges, Comparator.comparingInt(e -> e[2]));

        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        long cost = 0;
        int count = 0;

        for (int[] e : edges) {
            if (union(e[0], e[1])) {
                cost += e[2];
                count++;
                if (count == n - 1) break;
            }
        }

        System.out.println("cost=" + cost + " edges=" + count);
    }
}
