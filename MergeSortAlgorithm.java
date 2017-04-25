import java.util.*;

public class MergeSortAlgorithm {

	
	void mergesort(int[] array){
		int[] helper = new int[array.length];
		mergesort(array, helper, 0, array.length-1);
	}
	
	void mergesort(int[] array, int[] helper, int low, int high) {
		System.out.println("start mergesort with: low: " + low + " high: " + high + " low_value: " +array[low] +  " high_value: " + array[high]+   ";");
		if (low < high) {
			int middle = (low + high )/2;
			mergesort (array, helper, low, middle); // sort the left side
			
				//intermediary array print after Left 
				for (int i=0; i < array.length; i++){
					System.out.println("Intermediary_Left Array["+i+"] = " + array[i]);
				}
			
			mergesort (array, helper, middle+1, high); //sort the right side
			
				//intermediary array print after Right 
				for (int i=0; i < array.length; i++){
					System.out.println("Intermediary_Right Array["+i+"] = " + array[i]);
				}
			
				//debug print
				System.out.println("within mergesort with: low: " + low + " high: " + high + " low_value: " +array[low] +  " high_value: " + array[high]+   ";");
			
			//Merge
			merge(array, helper, low, middle, high); //merge them
			
				//debug print
				System.out.println("within mergesort after merge with: low: " + low + " high: " + high + " low_value: " +array[low] +  " high_value: " + array[high]+   ";");
		}
	}
	
	void merge(int[] array, int[] helper, int low, int middle, int high) {
		// copy initial array into the helper array
		for (int i=low; i <= high; i++) {
			helper[i] = array[i];
		}
		
		int current = low;
		int helperLeft = low;
		int helperRight = middle+1;
		
		while (helperLeft <= middle && helperRight <= high) {
			if (helper[helperLeft] <= helper[helperRight]) {
				array[current] = helper[helperLeft];
				helperLeft++;
			} else {
				array[current] = helper[helperRight];
				helperRight++;
			}
			current++ ;
		}
		
		// copy the rest of the left side of the array into the target array
		int remaining = middle - helperLeft ;
		for (int i=0; i<=remaining; i++) {
			array[current+i]=helper[helperLeft+i];
			System.out.println("within merge with: low: " + low + " high: " + high + " low_value: " +array[low] +  " high_value: " + array[high] +    "; current " + current);
		}
		System.out.println("End of merge with: low: " + low + " high: " + high + " low_value: " +array[low] +  " high_value: " + array[high]+   ";");
	}
	
	
	

	public static void main(String[] args) {
		
		// HashMap<String, String> hm = new HashMap<String, String>();
		int[] array = {9, 8, 9, 2, 7, 6};
		for (int i=0; i < array.length; i++){
			System.out.println("Initial Array["+i+"] = " + array[i]);
		}
		MergeSortAlgorithm ms = new MergeSortAlgorithm();
		ms.mergesort(array);
		for (int i=0; i < array.length; i++){
			System.out.println("Final Array["+i+"] = " + array[i]);
		}
		System.out.println("Finish");
		System.exit(0);
	}

}
