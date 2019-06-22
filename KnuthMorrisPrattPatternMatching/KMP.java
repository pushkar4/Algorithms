
public class KMP {

	private char[] t, p;
	private int[] L;
	private int n, m;

	public void search(String text, String pattern) {
		
		n = text.length();
		m = pattern.length();
		
		t = text.toCharArray();
		p = pattern.toCharArray();
		
		computePrefix();
		kmpMatcher();
	}

	private void computePrefix() {
		
		L = new int[m];
		
		L[0] = 0;
		int i = 1, j = 0;
		
		while(i < m) {
			if(p[i] == p[j]) {
				L[i] = j+1;
				i++;
				j++;
			} else {
				if(j != 0) {
					j = L[j-1];
				} else {
					L[i] = 0;
					i++;
				}
			}
		}
	}

	private void kmpMatcher() {
		
		int i = 0, j = 0;
		boolean found = false;
		
		while(i < n) {
			
			if(j == m-1) {
				found = true;
				j = L[j-1];
				System.out.println("Match found");
			}
			
			if(t[i] == p[j]) {
				i++;
				j++;
			} else {
				if(j != 0) {
					j = L[j-1];
				} else {
					i++;
				}
			}
		}
		
		if(! found)
			System.out.println("No match found");
		
		System.out.println();
	}
}
