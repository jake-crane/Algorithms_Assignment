/*		Programming Assignment #1
 * 		Date 11/8/2013
 * 		Name: Jake Crane
 * 		Program: This class contains all the necessary functions to Heapsort an integer array.
 * 			It uses a Heap object to help keep track of the heap size that is also defined in this file.
 * 		
 */

public class HeapSort {

	public static void heapsort(Heap A) {
		buildMaxHeap(A);
		for (int i = A.array.length - 1; i >= 1; i--) {
			int temp = A.array[0];
			A.array[0] = A.array[i];
			A.array[i] = temp;
			A.heapSize--;
			maxHeapify(A, 0);
		}
	}

	public static void buildMaxHeap(Heap A) {
		A.heapSize = A.array.length - 1;
		for (int i = (A.array.length - 1) / 2; i >= 0; i--) {
			maxHeapify(A, i);
		}
	}

	public static void maxHeapify(Heap A, int i) {

		int left = i * 2;
		int right = (i * 2) + 1;
		int largest = 0;
		
		if (left <= A.heapSize 	&& A.array[left] > A.array[i]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right <= A.heapSize 
				&& A.array[right] 
						> A.array[largest]) {
			largest = right;
		}

		if (largest != i) {
			int temp = A.array[largest];
			A.array[largest] = A.array[i];
			A.array[i] = temp;
			maxHeapify(A, largest);
		}
	}

	static class Heap {
		int[] array;
		int heapSize;

		public Heap(int... array) {
			this.array = array;
			heapSize = array.length - 1;
		}

	}

}
