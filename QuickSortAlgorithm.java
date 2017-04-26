
public class QuickSortAlgorithm {
	
	// array, left = first index, right = last index
	void quickSort(int[] arr, int left, int right){  
		int index = partition(arr, left, right);
		
		//sort the left half
		if(left < index -1) {
			quickSort(arr, left, index -1);
		}
		
		//sort the right half
		if(index < right) {
			quickSort(arr, index, right);
			
		}
			
	}
	
	int partition(int[] arr, int left, int right){
		int pivot = arr[(left + right)/2]; // pick pivot, avoiding the extremities of the array
		
		System.out.println("pivot_initial: " + pivot + "; left: " + arr[left] +"; right: " + arr[right] );
		
		while (left <= right ) {
			
				// printArray(arr, "Temp Array Before Left, partition()");  //debug
			
			//find the element of the left of the pivot that should be on the right 
			while (arr[left]<pivot) left++;
			
				//printArray(arr, "Temp Array Before Right, partition()");  //debug
			
				// System.out.println("right: " + right);
				// System.out.println("arr_right: " + arr[right]+ " pivot " + pivot);
			
			//find the element of the right of the pivot that should be on the left 
			while (arr[right]>pivot) right--;
				
				System.out.println("pivot: " + pivot + "; left: " + arr[left] +"; right: " + arr[right]);
			
				printArray(arr, "Temp Array End partition() : ");  //debug
			
			//swap this left element with this right element
			if(left <= right) {
				arr = swap(arr, left, right);
				left++; 
				right--;
			}
		}
		return left; 
	}
	
		
	int[] swap(int[] values, int left, int right) {
		  if (values == null ) throw new IllegalArgumentException("parameter must be an array of integers");
		  int temp = values[left];
		  values[left]=values[right];
		  values[right]=temp;
		  return values;
	}	
		
		

	public static void main(String[] args) {
		int[] array = {8, 9, 7, 3, 5, 4, 3, 8};
		
		QuickSortAlgorithm qs = new QuickSortAlgorithm();
		
			//printArray Initial - debug
			for (int i=0; i < array.length; i++){
				System.out.println("Initial Array["+i+"] = " + array[i]);
			}
		
		qs.quickSort(array, 0, array.length-1);
		
			// printArray final - debug
			for (int i=0; i < array.length; i++){
				System.out.println("Final Array["+i+"] = " + array[i]);
			}
			System.out.println("Finish");		
	}
	
	void printArray(int[] array, String str) {
		if (str == null) str = "";
		for (int i=0; i < array.length; i++){
			System.out.println(str + " " + array[i]);
		}
	}

}
