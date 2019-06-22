import io.github.pushkar4.TreePrinter;

public class OptimalMergePattern {
	
	File[] files = new File[100];
	int k = 0;
	File fileRoot = null;

	public void addFile(String name, int records) {
		files[k] = new File(name, records);
		k++;
	}

	public void findOptimalMergePattern() {
		
		FileMinHeap fileHeap = new FileMinHeap(files, k);
		
		fileHeap.buildFileMinHeap();
		
		//fileHeap.printHeap();
		
		while(fileHeap.size() > 1) {
			
			File file1 = fileHeap.popMin();
			File file2 = fileHeap.popMin();
			
			File fileParent = new File("", file1.records + file2.records);
			fileParent.left = file1;
			fileParent.right = file2;
			
			fileHeap.insert(fileParent);
		}
		
		fileRoot = fileHeap.popMin();
		
		TreePrinter.print(fileRoot);
	}
}
