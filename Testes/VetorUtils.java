public class VetorUtils {

	public static void swap(int data[], int pos1, int pos2){
		
		int x = data[pos1];
		data[pos1] = data[pos2];
		data[pos2] = x;
		
	}
	
	public static void bubblesort(Vector v, int n) {
		
		for(int i = 0; i < n - 1; i++){
			for(int j = n - 1; j > i; j--){
				if (v.data[j] < v.data[j - 1])
					swap(v.data, j, j - 1);
			}				
		}
		
	}
	
	public static void insertionSort(Vector v, int n) {

		int i, j, k;
		
L1:		for (i = 1; i < n; i++) {
			
L2:			k = v.data[i];
			
			j = i - 1;
			
L4:			while  (j >= 0 && v.data[j] > k) {
L7:				v.data[j + 1] = v.data[j];
				j--;
			}
			
L6:			v.data[j + 1] = k;
			
		}
		
L3:

	}
	
	public static void merge(int A[], int p, int q, int r){

    	int n1 = q - p + 1;
    	int n2 = r - q;
    	int i, j, k;
    	
    	p--;
    	
    	int L[] = new int[n1];
    	int R[] = new int [n2];
    	
L1:    	for (i = 0; i < n1; i++)
L2:    		L[i] = A[p + i];
    		
L3: 	for (i = 0; i < n2; i++)
L4:    		R[i] = A[q + i];
    		
    	i = 0;
    	j = 0;
    	
L5:    	for (k = p; k < r; k++) {
    	
L6:    		if (i == n1 && j < n2) {
    		
L10:    		while (k < r) {
L11:    			A[k] = R[j];
    				k++;
    				j++;
    			}
    			
L9:         } else if (i < n1 && j == n2){
    		
L14:    		while (k < r) {
L15:    			A[k] = L[i];
    				k++;
    				i++;
    			}
    		
L13:    	} else if (i < n1 && j < n2) {
    	
L17:    		if (L[i] <= R[j]){
L18:    			A[k] = L[i];
    				i++;
    			} else {
    				A[k] = R[j];
    				j++;
    			}
    		
    		}
L7:    	
    	}
    	
L7:

    }

    public static void mergesort(Vector vet[], int p, int r) {
    	
    	if (p < r) {
    		int q = (p + r) / 2;
    		mergesort(vet, p, q);
    		mergesort(vet, q + 1, r);
    		merge(vet.data, p, q, r);
    	}

    }
	
	
}