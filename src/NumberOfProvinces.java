import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {

    // DFS 100%
    // Time O(n^2)
    // Space O(n)
    public static int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int res = 0;
        boolean[] explored = new boolean[cities];
        for (int i = 0; i < cities; i++) {
            if (!explored[i]) {
                explored[i] = true;
                dfsProvince(isConnected, cities, i, explored);
                res++;
            }
        }
        return res;

    }

    public static void dfsProvince(int[][] isConnected, int n, int i, boolean[] explored) {
        for (int k = 0; k < n; k++) {
            if (!explored[k] && isConnected[i][k] == 1) {
                explored[k] = true;
                dfsProvince(isConnected, n, k, explored);
            }
        }
    }


    // BFS  88.54%
    public static int findCircleNumBFS(int[][] isConnected) {
        int cities = isConnected.length;
        int res = 0;
        boolean[] explored = new boolean[cities];
        for (int i = 0; i < cities; i++) {
            if (!explored[i]) {
                explored[i] = true;
                res++;
                // Start BFS
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int c = queue.poll();
                    for (int k = 0; k < cities; k++) {
                        if (!explored[k] && isConnected[c][k] == 1) {
                            queue.offer(k);
                            explored[k] = true;
                        }
                    }
                }
            }
        }
        return res;
    }


    // 并查集 88.54%
    public static int findCircleNumUnion(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        // 合并
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        // Union finished, count number of provinces
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }


    public static void main(String[] args) {
        int[][] test = new int[][]{{1,0,0,1},
                                   {0,1,1,0},
                                   {0,1,1,1},
                                   {1,0,1,1}};
        System.out.println(findCircleNum(test));
        System.out.println(findCircleNumBFS(test));
        System.out.println(findCircleNumUnion(test));
    }

}
