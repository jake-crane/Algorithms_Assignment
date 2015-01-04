/*		Programming Assignment #1
 * 		Date 11/8/2013
 * 		Name: Jake Crane
 * 		Program: This program runs Insertion Sort, Merge, Sort, Heap Sort and Quick Sort 
 * 			on randomized integer arrays of length 10, 100, 1000, 10000, 100000, 1000000 and 10000000.
 * 			Each algorithm sorts a copy of the same array for a fair comparison.
 * 			After each sort the length of the array and the time it took each algorithm to sort the array 
 * 			is printed.
 * 			The maximum number of of elements to sort is set with the max variable in main.
 * 		
 */

import java.util.concurrent.TimeUnit;

public class Test {

	public static void main(String[] args) {

		final int max = 100000; //maximum array length to test
		
		System.out.println(String.format("%25s%25s%25s%25s%25s", "Array Length", "Insertion Sort", "Merge Sort", 
				"Heap Sort", "Randomized Quick Sort"));
		
		for (int i = 10; i <= max; i*= 10) {

			int[] array = getRandomizedArray(i);
			//int[] array = getMixedArrayFromZeroTo(i);
			
			System.out.print(String.format("%25d", i));
			
			testInsertionSort(array.clone());

			testMergeSort(array.clone());

			testHeapSort(array.clone());

			testRandomizedQuickSort(array.clone());
			
			System.out.println();

		}
		
	}

	public static void testInsertionSort(int[] array) {

		long startTime = System.currentTimeMillis();

		InsertionSort.insertionSort(array);

		long sortTime = System.currentTimeMillis() - startTime;

		System.out.print(String.format("%25s", getFormattedTime(sortTime)));
		
	}

	public static void testMergeSort(int[] array) {

		long startTime = System.currentTimeMillis();

		MergeSort.mergeSort(array, 1, array.length);

		long sortTime = System.currentTimeMillis() - startTime;

		System.out.print(String.format("%25s", getFormattedTime(sortTime)));

	}

	public static void testHeapSort(int[] array) {

		long startTime = System.currentTimeMillis();

		HeapSort.heapsort(new HeapSort.Heap(array));

		long sortTime = System.currentTimeMillis() - startTime;

		System.out.print(String.format("%25s", getFormattedTime(sortTime)));

	}

	public static void testRandomizedQuickSort(int[] array) {

		long startTime = System.currentTimeMillis();

		QuickSort.randomizedQuickSort(array, 1, array.length);

		long sortTime = System.currentTimeMillis() - startTime;
		
		System.out.print(String.format("%25s", getFormattedTime(sortTime)));
	}
	
	public static String getFormattedTime(long timeInMillis) {
		
		long displayHours = TimeUnit.MILLISECONDS.toHours(timeInMillis);
		long displayMinutes = TimeUnit.MILLISECONDS.toMinutes(timeInMillis) - TimeUnit.HOURS.toMinutes(displayHours);
		long displaySeconds = TimeUnit.MILLISECONDS.toSeconds(timeInMillis) - TimeUnit.HOURS.toSeconds(displayHours) 
				- TimeUnit.MINUTES.toSeconds(displayMinutes);
		long displayMilliSeconds = timeInMillis - TimeUnit.HOURS.toMillis(displayHours) 
				- TimeUnit.MINUTES.toMillis(displayMinutes) - TimeUnit.SECONDS.toMillis(displaySeconds);
		
		return String.format("%02dh:%02dm:%02ds:%02dms", displayHours, displayMinutes, displaySeconds, displayMilliSeconds);

	}

	public static int getRandomInt(final int min, final int max) {
		return (int)( min + Math.random() * (1 + max - min) );
	}
	
	private static int[] getMixedArrayFromZeroTo(int length)  {
		int[] array = new int[length];
		for (int i = 0; i < array.length; i++) {
			array[i] = length - i;
		}
	
		int temp;
		int randomIndex;
		for (int i = 0; i < array.length; i++) {
			randomIndex = (int)(Math.random() * length);
			temp = array[i];
			array[i] = array[randomIndex];
			array[randomIndex] = temp;
		}
	
		return array;
	}
	
	private static int[] getRandomizedArray(int length)  {
		int[] array = new int[length];

		for (int i = 0; i < array.length; i++) {
			array[i] = getRandomInt(0, Integer.MAX_VALUE - 1);
		}

		return array;
	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");

		}
		System.out.println(array[array.length - 1]);
	}
}
