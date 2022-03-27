import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    // 设置两个数组便于计算周围坐标
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, 1, -1, 0};

    // Solution 1: BFS  O(len * wid)  42.89%
    public int[][] floodFillBFS(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        // 该像素已上色
        if (curColor == newColor) {
            return image;
        }

        int len = image.length, wid = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            // 上色需要被移除队列的像素
            int[] pixel = queue.poll();
            int x = pixel[0], y = pixel[1];
            image[x][y] = newColor;
            // 向上下左右各方向扩展
            for (int i=0; i<4; i++) {
                int xx = x + dx[i], yy = y + dy[i];
                // 判断是否和初始颜色一致，注意边界限制
                if (xx >=0 && xx < len && yy >= 0 && yy < wid && image[xx][yy] == curColor) {
                    queue.offer(new int[]{xx, yy});
                }
            }
        }
        return image;
    }

    // Solution 2: DFS  O(len * wid)  100%
    // DFS may be more suitable in this case since there are solutions that far away from the source
    public int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            int len = image.length, wid = image[0].length;
            dfs(image, len, wid, sr, sc, oldColor, newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int len, int wid, int x, int y, int oldColor, int newColor) {
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int xx = x + dx[i], yy = y + dy[i];
                // Expand
                if (xx >= 0 && xx < len && yy >= 0 && yy < wid) {
                    dfs(image, len, wid, xx, yy, oldColor, newColor);
                }
            }
        }
    }

}
