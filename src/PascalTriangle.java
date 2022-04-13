import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // Attempt 1  DP  100%
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res  = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);
        if (numRows == 1) {
            return res;
        }
        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        res.add(temp);
        for (int i=3; i<=numRows; i++) {
            // 生成当前层
            temp = generateLayer(temp);
            res.add(temp);
        }
        return res;
    }

    public static List<Integer> generateLayer(List<Integer> prev) {
        List<Integer> curr = new ArrayList<>();
        // 头部 1
        curr.add(1);
        for (int i=0; i<prev.size() - 1; i++) {
            curr.add(prev.get(i) + prev.get(i + 1));
        }
        // 尾部 1
        curr.add(1);
        return curr;
    }


    // 官方解法，思路差不多，代码更精简
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<>();
            // 每行的元素个数 = 这是第几行
            for (int j = 0; j <= i; ++j) {
                // 每行首尾均为 1
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // 中间的元素通过前一层可以获取
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }


    public static void main(String[] args) {
        System.out.println(generate(10));
    }

}
