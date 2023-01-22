import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AllPathsFromSrcToTarget {

    // 官方 DFS  100%
    // 利用 stack
    public static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public static Deque<Integer> stack = new ArrayDeque<Integer>();

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        stack.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public static void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<>(stack));
            return;
        }
        for (int y : graph[x]) {
            // 更新路径
            stack.offerLast(y);
            dfs(graph, y, n);
            // 去尾 移除已经被记录过的路径
            stack.pollLast();
        }
    }


    // Attempt 1  DFS  59.52%
    public static List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
        int n = graph.length; // 终点
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs1(graph, 0, path, paths);
        return paths;
    }

    public static void dfs1(int[][] graph, int node, List<Integer> path, List<List<Integer>> paths) {
        // 到达终点
        if (node == graph.length - 1) {
            List<Integer> newPath = new ArrayList<>();
            newPath.addAll(path);
            paths.add(newPath);
            return;
        }
        for (int nextNode: graph[node]) {
            List<Integer> newPath = new ArrayList<>();
            newPath.addAll(path);
            newPath.add(nextNode);
            dfs1(graph, nextNode, newPath, paths);
        }
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1,2}, {3}, {3}, {}};
        int[][] test2 = new int[][]{{4,3,1}, {3,2,4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(test1));
    }

}
