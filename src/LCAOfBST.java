import java.util.ArrayList;
import java.util.List;

public class LCAOfBST {

    // 一次遍历 100%
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    // 一次遍历 递归 100%
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        return root;
    }

    // 二次遍历
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 获取从 root 到 两个点的路径
        List<TreeNode> pPath = getPath(root, p);
        List<TreeNode> qPath = getPath(root, q);
        TreeNode ancestor = null;
        // 找出最近公共点
        for (int i=0; i<pPath.size() && i<qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                ancestor = pPath.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode node, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode temp = node;
        while (temp != target) {
            path.add(node);
            if (target.val < temp.val) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        path.add(temp);
        return path;
    }

}
