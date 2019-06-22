
public class Test01Knapsack {

	public static void main(String[] args) {
		
		Knapsack k = new Knapsack(new int[]{1,2,4}, new int[]{10,12,28}, 6);
		k.findMaxProfit();
		
		System.out.println();
		
		Knapsack k2 = new Knapsack(new int[]{9, 13, 153, 50, 15, 68,27,39,23,52,11,32,24,48,73,42,43,22,7,18,4}, new int[]{150,35,200,160,60,45,60,40,30,10,70,30,15,10,40,70,75,80,20,12,50}, 400);
		k2.findMaxProfit();
		
		System.out.println();
		
		Knapsack k3 = new Knapsack(new int[]{10, 20, 30}, new int[]{60, 100, 120}, 50);
		k3.findMaxProfit();
		
	}
}
