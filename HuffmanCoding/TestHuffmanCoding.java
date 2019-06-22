
public class TestHuffmanCoding {

	public static void main(String[] args) {
		
		HuffmanCode h = new HuffmanCode();
		
		char[] C = {'a', 'b', 'c', 'd', 'e', 'f'};
		int[]  F = { 45,  13,  12,  16,  9,   5};
		h.doHuffmanCoding(C, F);
		
		System.out.println();
		
		char[] C2 = {'a', 'b', 'c', 'd'};
		int[]  F2 = { 50,  40,  5,   5};
		h.doHuffmanCoding(C2, F2);
		
		System.out.println();
		
		char[] C3 = {'a', 'b', 'c', 'd', 'e', 'f'};
		int[]  F3 = { 40,  30,  20,  5,   3,   2};
		h.doHuffmanCoding(C3, F3);
		
	}
}
