
public class TestLcs {

	public static void main(String[] args) {
		
		Lcs lcs = new Lcs("AAB", "ACA");
		lcs.computeLcs();
		
		System.out.println();
		
		Lcs lcs2 = new Lcs("ABCBDAB", "BDCABA");
		lcs2.computeLcs();
		
		System.out.println();
		
		Lcs lcs3 = new Lcs("qpqrr", "pqprqrp");
		lcs3.computeLcs();
		
		
	}
}
