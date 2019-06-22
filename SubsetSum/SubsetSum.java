
public class SubsetSum {

	private int[] set;
	private int sum;
	
	public SubsetSum(int[] set, int sum) {
		this.set = set;
		this.sum = sum;
	}
	
	public void findSubset() {
		
		int n = set.length;
		boolean subset[][] = new boolean[n][sum+1];

        for(int i=0; i<n; i++)
            subset[i][0] = true;

        for(int i=1; i<=sum; i++)
            subset[0][i] = false;

        for(int i=1; i<n; i++) {
            for(int j=1; j<=sum; j++) {

                if(set[i] > j) {
                    subset[i][j] = subset[i-1][j];
                } else {
                    subset[i][j] = subset[i-1][j] || subset[i-1][j-set[i]];
                }
            }
        }

        System.out.println(subset[n-1][sum]);
	}
}
