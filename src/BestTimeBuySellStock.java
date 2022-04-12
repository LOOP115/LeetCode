public class BestTimeBuySellStock {

    // 双指针尝试了很久，最终失败，本题用动态规划比较清晰
    // 今天之前买入的最小值
    // 今天的获利等于今天的卖出价 - 今天之前的最小值
    // 比较每天的最大获利
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) {
            return 0;
        }
        int minBuy = prices[0];
        int maxProfit = 0;
        for (int i=1; i<n; i++) {
            minBuy = Math.min(prices[i], minBuy);
            maxProfit = Math.max(prices[i] - minBuy, maxProfit);
        }
        return maxProfit;
    }

    // 官方解答，思路和上面一样，运行更快，击败 100%
    public static int maxProfit1(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }


    public static void main(String[] args) {
        int[] test = {11,7,1,4,2};
        System.out.println(maxProfit1(test));
    }

}
