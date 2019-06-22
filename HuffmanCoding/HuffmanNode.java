
public class HuffmanNode {
	
	char character;
	int frequency;
	HuffmanNode left, right;
	
	public HuffmanNode(char c, int f) {
		
		character = c;
		frequency = f;
		left = null;
		right = null;
	
	}
}
