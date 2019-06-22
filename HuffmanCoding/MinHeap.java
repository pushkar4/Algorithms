
public class MinHeap {
	
	private int heapSize, N;
	private HuffmanNode[] A = new HuffmanNode[100];
	
	MinHeap(HuffmanNode[] a) {
		heapSize = 0;
		N = a.length;
		System.arraycopy(a, 0, A, 0, a.length);
	}
	
	
	public int getHeapSize() {
		return heapSize;
	}
	
	public void buildMinHeap() {
		
		heapSize = N;
		
		for(int i = heapSize/2; i >= 0; i--) {
			minHeapify(A, i);
		}
	}	

	private void minHeapify(HuffmanNode[] A, int i) {
		
		int l = 2*i + 1;
		int r = 2*i + 2;
		
		int minPos = i;
		
		if(l < heapSize && A[l].frequency < A[i].frequency)
			minPos = l;
		
		if(r < heapSize && A[r].frequency < A[minPos].frequency)
			minPos = r;
		
		if(minPos != i) {
			HuffmanNode t = A[i];
			A[i] = A[minPos];
			A[minPos]  = t;
			
			minHeapify(A, minPos);
		}
	}
	
	public void insert(HuffmanNode h) {
		
		heapSize++;
		int pos = heapSize-1;
		
		A[pos] = h;
		
		while(A[(pos-1)/2].frequency > A[pos].frequency) {
			HuffmanNode t = A[(pos-1)/2];
			A[(pos-1)/2] = A[pos];
			A[pos] = t;
		}
	}
	
	public HuffmanNode popMin() {
		
		if(heapSize < 1) 
			return null;
		
		HuffmanNode minNode = A[0];
		
		A[0] = A[heapSize-1];
		heapSize--;
		minHeapify(A, 0);
		
		return minNode;
	}
}
