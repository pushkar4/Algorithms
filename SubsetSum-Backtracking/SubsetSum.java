
public class SubsetSum {

	int N, sum, totalRemaining;
	int[] set;
	boolean[] chosen;
	
	public SubsetSum(int[] set, int sum) {
		this.set = set;
		N = set.length;
		this.sum = sum;
		chosen = new boolean[N];
		totalRemaining = 0;
		for (int a : set) {
			totalRemaining += a;
		}
	}
	
	public void findSubSet() {
		
		solve(0, 0, totalRemaining);
	}

	private boolean solve(int i, int sumTillNow, int totalRemaining) {
		
		if(i == N)
			return false;
		
		for(int j = i; j < N; j++) {
			
		}
		
		
		
		
		
		if(sumTillNow == sum) {
			// Found solution
		}
		
		if(sumTillNow > sum || sumTillNow + totalRemaining < sum ) {
			// backtrack
		}
		
		chosen[i] = true;
		boolean res = solve(i+1, sumTillNow+set[i], totalRemaining-set[i]);
		if(res)
			return true;
		else {
			
		}
		
		
		
		return false;
	}
}
