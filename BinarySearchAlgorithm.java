
public class BinarySearchAlgorithm {
	
	// Binary Search
	int binarySearch(int[]a, int x) {
		int low = 0 ; // is zero
		int high = a.length - 1;
		int mid ;

		while (low <= high) {
			mid = (high + low)/2;
			if (a[mid]<x){
				low = mid +1;
			}else if (a[mid] > x) {
				high = mid -1;
			} else {
				return mid;
			}

		}

		return -1; //error
	}
	
	// Resolve the binary search recursively
	int binarySearchRecursive(int[] arr, int x, int low, int high) {
		if (low > high) return -1; //error

		int mid = (low + high) / 2;

		if (arr[mid] < x) {
			return binarySearchRecursive(arr, x, mid+1, high);
		} else if (x < arr[mid]) {
			return binarySearchRecursive(arr, x, low, mid-1);
		} else return mid ;
	}

}
