import java.util.LinkedList;
import java.util.Queue;

import io.github.pushkar4.TreePrinter;
import io.github.pushkar4.TreePrinter.PrintableNode;

public class Tree {
	
	private class Node implements PrintableNode {
		File file;
		Node left;
		Node right;
		
		Node(File file) {
			this.file = file;
			this.left = null;
			this.right = null;
		}

		@Override
		public PrintableNode getLeft() {
			return this.left;
		}

		@Override
		public PrintableNode getRight() {
			return this.right;
		}

		@Override
		public String getText() {
			return this.file.name + ":" + String.valueOf(this.file.records);
		}
	}
	
	private Node root;
	
	public void show() {
		TreePrinter.print(root);
	}

	public void createAndPrint(File[] A, int n) {
		
		if(n < 1) {
			System.out.println("No tree to print");
			return;
		}
		
		root = new Node(A[0]);
		
		Queue<Node> q = new LinkedList<Node>();
		
		q.add(root);
		
		for(int i = 1; i < n; i++) {
			
			Node parent = q.peek();
			Node node = new Node(A[i]);
			
			if(parent.left == null)
				parent.left = node;
			else if(parent.right == null) {
				parent.right = node;
				q.remove();
			}
				
			q.add(node);
		}
		
		show();
	}
}