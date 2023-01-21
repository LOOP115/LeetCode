import java.util.*;

public class SubtreeOfAnotherTree {


    // Brute DFS  70.25%
    public boolean isSubtreeDFS(TreeNode s, TreeNode t) {
        return dfs(s, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        return check(s, t) || dfs(s.left, t) || dfs(s.right, t);
    }

    public boolean check(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }
        return check(s.left, t.left) && check(s.right, t.right);
    }


    // Attempt 1 层序遍历 很慢
    public boolean isSubtree1(TreeNode root, TreeNode subRoot) {
        // Find the node that has the same value as sub root
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == subRoot.val) {
                if (sameTree(node, subRoot)) {
                    return true;
                }
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return false;
    }

    public boolean sameTree(TreeNode tree1, TreeNode tree2) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(tree1);
        queue2.offer(tree2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // Check if the same layer has the same number of sub nodes
            if (queue1.size() != queue2.size()) {
                return false;
            }
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            int leftCnt = 0;
            int rightCnt = 0;

            if (node1.left != null) {
                queue1.offer(node1.left);
                leftCnt++;
            }
            if (node1.right != null) {
                queue1.offer(node1.right);
                rightCnt++;
            }
            if (node2.left != null) {
                queue2.offer(node2.left);
                leftCnt++;
            }
            if (node2.right != null) {
                queue2.offer(node2.right);
                rightCnt++;
            }
            if (leftCnt % 2 != 0 || rightCnt % 2 != 0) {
                return false;
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();
    }


    // 深度优先搜索序列上做串匹配
    List<Integer> sOrder = new ArrayList<>();
    List<Integer> tOrder = new ArrayList<>();
    int maxElement, lNull, rNull;

    public boolean isSubtree(TreeNode s, TreeNode t) {
        maxElement = Integer.MIN_VALUE;
        getMaxElement(s);
        getMaxElement(t);
        lNull = maxElement + 1;
        rNull = maxElement + 2;

        getDfsOrder(s, sOrder);
        getDfsOrder(t, tOrder);

        return kmp();
    }

    public void getMaxElement(TreeNode t) {
        if (t == null) {
            return;
        }
        maxElement = Math.max(maxElement, t.val);
        getMaxElement(t.left);
        getMaxElement(t.right);
    }

    public void getDfsOrder(TreeNode t, List<Integer> tar) {
        if (t == null) {
            return;
        }
        tar.add(t.val);
        if (t.left != null) {
            getDfsOrder(t.left, tar);
        } else {
            tar.add(lNull);
        }
        if (t.right != null) {
            getDfsOrder(t.right, tar);
        } else {
            tar.add(rNull);
        }
    }

    public boolean kmp() {
        int sLen = sOrder.size(), tLen = tOrder.size();
        int[] fail = new int[tOrder.size()];
        Arrays.fill(fail, -1);
        for (int i = 1, j = -1; i < tLen; ++i) {
            while (j != -1 && !(tOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (tOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            fail[i] = j;
        }
        for (int i = 0, j = -1; i < sLen; ++i) {
            while (j != -1 && !(sOrder.get(i).equals(tOrder.get(j + 1)))) {
                j = fail[j];
            }
            if (sOrder.get(i).equals(tOrder.get(j + 1))) {
                ++j;
            }
            if (j == tLen - 1) {
                return true;
            }
        }
        return false;
    }


    // Hash  过于复杂  16.38%
    static final int MAX_N = 1005;
    static final int MOD = 1000000007;
    boolean[] vis = new boolean[MAX_N];
    int[] p = new int[MAX_N];
    int tot;
    Map<TreeNode, int[]> hS = new HashMap<>();
    Map<TreeNode, int[]> hT = new HashMap<>();

    public boolean isSubtreeHash(TreeNode s, TreeNode t) {
        getPrime();
        dfs(s, hS);
        dfs(t, hT);
        int tHash = hT.get(t)[0];
        for (Map.Entry<TreeNode, int[]> entry : hS.entrySet()) {
            if (entry.getValue()[0] == tHash) {
                return true;
            }
        }
        return false;
    }

    public void getPrime() {
        vis[0] = vis[1] = true;
        tot = 0;
        for (int i = 2; i < MAX_N; ++i) {
            if (!vis[i]) {
                p[++tot] = i;
            }
            for (int j = 1; j <= tot && i * p[j] < MAX_N; ++j) {
                vis[i * p[j]] = true;
                if (i % p[j] == 0) {
                    break;
                }
            }
        }
    }

    public void dfs(TreeNode o, Map<TreeNode, int[]> h) {
        h.put(o, new int[]{o.val, 1});
        if (o.left == null && o.right == null) {
            return;
        }
        if (o.left != null) {
            dfs(o.left, h);
            int[] val = h.get(o);
            val[1] += h.get(o.left)[1];
            val[0] = (int) ((val[0] + (31L * h.get(o.left)[0] * p[h.get(o.left)[1]]) % MOD) % MOD);
        }
        if (o.right != null) {
            dfs(o.right, h);
            int[] val = h.get(o);
            val[1] += h.get(o.right)[1];
            val[0] = (int) ((val[0] + (179L * h.get(o.right)[0] * p[h.get(o.right)[1]]) % MOD) % MOD);
        }
    }

}
