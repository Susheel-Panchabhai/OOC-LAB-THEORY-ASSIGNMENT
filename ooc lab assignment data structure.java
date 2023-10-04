
import java.util.Scanner;

public class MedianOfTwoArrays {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of elements in the first array: ");
		int n1 = scanner.nextInt();

		System.out.print("Enter the number of elements in the second array: ");
		int n2 = scanner.nextInt();

		System.out.println("Enter the elements for the first array:");
		int[] arr1 = new int[n1];
		for (int i = 0; i < n1; i++) {
			arr1[i] = scanner.nextInt();
		}


		System.out.println("Enter the elements for the second array:");
		int[] arr2 = new int[n2];
		for (int i = 0; i < n2; i++) {
			arr2[i] = scanner.nextInt();
		}


		sortArray(arr1);
		sortArray(arr2);


		double median = findMedian(arr1, arr2);


		System.out.print("Sorted First Array: ");
		printArray(arr1);
		System.out.print("Sorted Second Array: ");
		printArray(arr2);
		int[] mergedArray = mergeArrays(arr1, arr2);
		System.out.print("Merged Array: ");
		printArray(mergedArray);

		// Output the median
		System.out.println("Median: " + median);

		// Close the scanner
		scanner.close();
	}

	// Custom sorting function (You can replace this with your preferred sorting algorithm)
	private static void sortArray(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// Swap arr[j] and arr[j+1]
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	// Custom function to find the median of two sorted arrays
	private static double findMedian(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;
		int totalLength = m + n;
		int[] mergedArray = new int[totalLength];
		int i = 0, j = 0, k = 0;

		while (i < m && j < n) {
			if (arr1[i] <= arr2[j]) {
				mergedArray[k] = arr1[i];
				i++;
			} else {
				mergedArray[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < m) {
			mergedArray[k] = arr1[i];
			i++;
			k++;
		}

		while (j < n) {
			mergedArray[k] = arr2[j];
			j++;
			k++;
		}

		if (totalLength % 2 == 0) {
			// If the combined array has an even number of elements, average the middle two
			int mid1 = mergedArray[(totalLength / 2) - 1];
			int mid2 = mergedArray[totalLength / 2];
			return (double)(mid1 + mid2) / 2.0;
		} else {
			// If the combined array has an odd number of elements, take the middle element
			return (double) mergedArray[totalLength / 2];
		}
	}


	// Custom function to merge two sorted arrays
	private static int[] mergeArrays(int[] arr1, int[] arr2) {
		int m = arr1.length;
		int n = arr2.length;
		int totalLength = m + n;
		int[] mergedArray = new int[totalLength];
		int i = 0, j = 0, k = 0;

		while (i < m && j < n) {
			if (arr1[i] <= arr2[j]) {
				mergedArray[k] = arr1[i];
				i++;
			} else {
				mergedArray[k] = arr2[j];
				j++;
			}
			k++;
		}

		while (i < m) {
			mergedArray[k] = arr1[i];
			i++;
			k++;
		}

		while (j < n) {
			mergedArray[k] = arr2[j];
			j++;
			k++;
		}

		return mergedArray;
	}

	private static void printArray(int[] arr) {
		for (int num : arr ) {
			System.out.print(num + " ");
		}
		System.out.println();
	}
}
