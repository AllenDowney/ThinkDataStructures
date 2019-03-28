package com.g4k13.datastructures;

public class MySelectionSort {

	/* Runtime is Quadratic, O(n^2)
	 * 
	 */
	
	public static void swapElements(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int indexLowest(int[] array, int start) {
		int lowIndex = start;
		for (int i = start; i < array.length; i++) {
			if (array[i] < array[lowIndex]) {
				lowIndex = i;
			}
		}
		return lowIndex;
	}
	
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int j = indexLowest(array, i);
			swapElements(array, i, j);
		}
	}
	
	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
		}
		System.out.println("-------------");
	}
	
	public static void main(String[] args) {
		System.out.println("Testing Selection Sort");
		int[] numbers = new int[]{1,4,8,3,2};
		printArray(numbers);
		selectionSort(numbers);
		printArray(numbers);

	}

}
