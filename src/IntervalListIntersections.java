import java.util.ArrayList;

public class IntervalListIntersections {

    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        // Find intersections
        while (i < firstList.length && j < secondList.length) {
            // Head
            int head = Math.max(firstList[i][0], secondList[j][0]);
            // Tail
            int tail = Math.min(firstList[i][1], secondList[j][1]);
            if (head <= tail) {
                ans.add(new int[]{head, tail});
            }
            // Remove the interval will smaller tail
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else if (firstList[i][1] > secondList[j][1]) {
                j++;
            } else {
                i++;
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void printIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            System.out.println("[]");
            return;
        }
        for (int[] i: intervals) {
            System.out.println("[" + i[0] + ", " + i[1] + "]");
        }
    }

    public static void main(String[] args) {
        int[][] first = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] second = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        printIntervals(intervalIntersection(first, second));
    }

}
