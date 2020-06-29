
public class BestTimeToBuySellStock {
	public int maxProfit(int[] prices) {

		int n = prices.length;
		int min = Integer.MAX_VALUE;
		int maxprofit = 0;

		for (int i = 0; i < n; i++) {
			int profit = prices[i] - min;
			maxprofit = Math.max(maxprofit, profit);
			min = Math.min(min, prices[i]);
		}
		return maxprofit;

	}
}
