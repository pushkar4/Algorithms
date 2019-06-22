/*
 * Time is O(mn)
 */

import java.util.Stack;

public class Lcs {

	private String seq1, seq2;
	private int m, n;
	private int[][] c;
	
	public Lcs(String s1, String s2) {
		seq1 = " " + s1;
		seq2 = " " + s2;
		
		m = seq1.length();
		n = seq2.length();
		
		c = new int[m][n];
	}
	
	public void computeLcs() {
		
//		Not needed
//		for(int i = 0; i < m; i++)
//			c[i][0] = 0;
//		
//		for(int j = 0; j < n; j++)
//			c[0][j] = 0;
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				
				char a = seq1.charAt(i);
				char b = seq2.charAt(j);
				
				if(a == b) {
					c[i][j] = 1 + c[i-1][j-1];
				} else {
					
					if(c[i-1][j] > c[i][j-1]) {
						c[i][j] = c[i-1][j];
					} else {
						c[i][j] = c[i][j-1];
					}					
				}
			}
		}
		
		System.out.print("LCS of length " + c[m-1][n-1] + " is");
		printLcs(m-1, n-1);
		System.out.println();
		
		Stack<Character> stack = new Stack<Character>();
		printAllLcs(stack, m-1, n-1);
	}

	private void printLcs(int i, int j) {
		if(i < 0 || j < 0)
			return;
		
		if(seq1.charAt(i) == seq2.charAt(j)) {
			printLcs(i-1, j-1);
			System.out.print(seq1.charAt(i));
		} else {
			
			if( i-1 >= 0 && c[i-1][j] == c[i][j] )
				printLcs(i-1, j);
			else if( j-1 >= 0 )
				printLcs(i, j-1);
		}
	}
	
	private void printAllLcs(Stack<Character> stack, int i, int j) {
		if(i < 0 || j < 0) {
			while( ! stack.isEmpty() )
				System.out.print(stack.pop());
			System.out.println();
			return;
		}
		
		if(seq1.charAt(i) == seq2.charAt(j)) {
			stack.push(seq1.charAt(i));
			printAllLcs(stack, i-1, j-1);
		} else {
			
			if( (i-1 >= 0) && (j-1 >= 0) && 
					c[i-1][j] == c[i][j-1] ) {
				
				Stack<Character> stackNew = (Stack<Character>) stack.clone();
				
				printAllLcs(stack, i-1, j);
				printAllLcs(stackNew, i, j-1);
			}
			else if( (i-1 >= 0) && c[i-1][j] == c[i][j] )
				printAllLcs(stack, i-1, j);
			else
				printAllLcs(stack, i, j-1);
		}
	}
}
