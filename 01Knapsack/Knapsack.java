
public class Knapsack {
	
	private int N, capacity;
	private int[] weight;
	private int[] profit;
	private int[][] maxPro;
	
	public Knapsack(int[] weight, int[] profit, int capacity) {
		this.weight = weight;
		this.profit = profit;
		this.capacity = capacity;
		this.N = weight.length;
		this.maxPro = new int[N+1][capacity+1];
	}
	
	public void findMaxProfit() {
		
		for(int i = 0; i < N+1; i++)
			maxPro[i][0] = 0;
		
		for(int i = 0; i <= capacity; i++)
			maxPro[0][i] = 0;
		
		for(int i = 1; i < N+1; i++) {
			for(int w = 1; w <= capacity; w++) {
				
				if(weight[i-1] > w)
					maxPro[i][w] = maxPro[i-1][w];
				else {
					int p1 = profit[i-1] + maxPro[i-1][w-weight[i-1]];
					int p2 = maxPro[i-1][w];
					
					maxPro[i][w] = (p1 > p2) ? p1 : p2;
				}
			}
		}
		
		System.out.println("Max Profit is " + maxPro[N][capacity]);
	}
}
